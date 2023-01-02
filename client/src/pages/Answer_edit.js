import styled from 'styled-components';
import InpTxt from '../components/inpTxt/InpTxt';
import BtnBasic from '../components/btnBasic/BtnBasic';
import { useEffect, useState } from 'react';
import { useNavigate, useSearchParams } from 'react-router-dom';
import axios from 'axios';
import LoadingDiv from '../components/loading/Loading';
import { withCookies, Cookies } from 'react-cookie';

const Wrapper = styled.div`
  width: 1100px;
  box-sizing: border-box;
  padding: 24px 24px 80px;
  margin: 0 auto;
  background-color: hsl(210, 8%, 97.5%);
`;

const BoxWrite = styled.div`
  position: relative;
  padding-right: 300px;
  margin-top: 14px;

  .contWrite {
    background-color: #fff;
    padding: 24px;
    border: 1px solid hsl(210, 8%, 90%);
    border-radius: 3px;
  }

  .tipWrite {
    position: absolute;
    right: 0;
    top: 0;
    box-shadow: 0 1px 2px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05),
      0 2px 8px hsla(0, 0%, 0%, 0.05);
    border: 1px solid hsl(210, 8%, 85%);
    width: 100px;
    height: 100px;
  }
`;

const BtnRow = styled.div`
  margin-top: 30px;
`;

const Cancel = styled.button`
  width: 200.5;
  height: 42.3;
  color: hsl(206, 100%, 40%);
`;

const NoticeWrite = styled.div`
  background-color: hsl(47, 87%, 94%);
  border: 1px solid hsl(47, 69%, 69%);
  border-radius: 3px;
  padding: 24px;
  color: rgba(59, 54, 69);
  width: 750px;
  box-sizing: border-box;

  .titNw {
    display: block;
    font-size: 21px;
    font-weight: normal;
    margin-bottom: 6px;
  }

  p {
    font-size: 12px;

    a {
      color: rgba(0, 116, 204);
    }
  }

  .titStepList {
    display: block;
    margin-top: 15px;
  }

  .listStep {
    list-style: disc;
    margin-left: 30px;

    li {
      list-style: disc;
    }
  }
`;

const userCookiesData = new Cookies();
const userCookiesGetData = userCookiesData.get('userCookies');

const Answer_edit = () => {
  const navigate = useNavigate();
  useEffect(() => {
    if (userCookiesGetData === undefined) {
      navigate('/login');
    }
  }, []);
  const [answer, setAnswer] = useState('');
  // const [tags, setTag] = useState('');
  const [searchParams] = useSearchParams();
  const questionId = searchParams.get('questionId');
  const answerId = searchParams.get('answerId');
  const [loading, setLoading] = useState(false);

  // const makeTagArray = (tagString) => {
  //   const tagArray = tagString.trim().split(',');
  //   return tagArray;
  // };

  useEffect(() => {
    axios
      .get(
        `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/answer?questionId=${questionId}`,
        {
          headers: {
            Authorization: userCookiesGetData.authorization,
          },
        }
      )
      .then((res) => {
        const filterData = res.data.data.filter((it) => {
          if (it.answerId === Number(answerId)) {
            return it;
          }
        });
        // if (res.data.data.tags !== null) setTag(res.data.data.tags.join(', '));
        setAnswer(filterData[0].content);
      });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    setLoading(true);
    setTimeout(() => {
      try {
        axios
          .patch(
            `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/answer/${answerId}`,
            {
              answerId: answerId,
              content: answer,
              // tags: makeTagArray(tags),
            },
            {
              headers: {
                Authorization: userCookiesGetData.authorization,
              },
            }
          )
          .then(setLoading(false))
          .then(alert('수정 완료하였습니다'));
        navigate(`/board?questionId=${questionId}`);
      } catch (error) {
        console.log(error);
      }
    }, 2000);
  };
  return (
    <div>
      <Wrapper>
        <NoticeWrite>
          <p>Please correct your answer.</p>
          <br />
          <p>You can modify tags and answers</p>
        </NoticeWrite>

        <form onSubmit={handleSubmit}>
          <BoxWrite>
            <div className="contWrite">
              <strong className="titCw">Correct your answer</strong>
              <div className="txtFiledCw">
                <InpTxt
                  autoComplete="off"
                  value={answer}
                  onChange={setAnswer}
                />
              </div>
            </div>
            <div className="tipWrite"></div>
          </BoxWrite>

          {/* <BoxWrite>
            <div className="contWrite">
              <strong className="titCw">Tags</strong>
              <div className="txtFiledCw">
                <InpTxt autoComplete="off" value={tags} onChange={setTag} />
              </div>
            </div>
            <div className="tipWrite"></div>
          </BoxWrite> */}

          <BtnRow>
            <BtnBasic>
              <button type="submit">Save edits</button>
            </BtnBasic>
            <Cancel onClick={() => navigate(`/board?questionId=${questionId}`)}>
              Cancel
            </Cancel>
          </BtnRow>
        </form>
        {loading && <LoadingDiv>Loading...</LoadingDiv>}
      </Wrapper>
    </div>
  );
};

export default withCookies(Answer_edit);
