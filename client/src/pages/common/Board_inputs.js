import styled from 'styled-components';
import TitleBasic from '../../components/titleBasic/TitleBasic';
import InpTxt from '../../components/inpTxt/InpTxt';
import BtnBasic from '../../components/btnBasic/BtnBasic';
import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import LoadingDiv from '../../components/loading/Loading';
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

const NoticeWrite = styled.div`
  background-color: rgba(234, 244, 251);
  border: 1px solid rgba(166, 206, 237);
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
    font-size: 15px;

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

const Board_inputs = () => {
  const [title, setTitle] = useState('');
  const [problem, setProblem] = useState('');
  const [trying, setTrying] = useState('');
  const [tags, setTag] = useState('');
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();
  const makeSetTag = (stringTag) => {
    setTag(stringTag.trim().split(','));
  };
  const authorization_cookie = new Cookies();
  console.log(authorization_cookie.get('cookie_name'));

  const handleSubmit = (e) => {
    e.preventDefault();
    setLoading(true);
    setTimeout(() => {
      try {
        axios
          .post(
            'http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/question',
            {
              title: title,
              questionContent: problem,
              attemptContent: trying,
              tags: tags,
            },
            { withCredentials: true }
          )
          .then((res) => console.log(res.data))
          .then(setLoading(false))
          .then(alert('추가되었습니다'));
        navigate('/board_list?page=1');
      } catch (error) {
        console.log(error);
      }
    }, 2000);
  };
  // const bannerCookie = useCookies(['cookie_name']);
  // console.log(bannerCookie)
  return (
    <Wrapper>
      <TitleBasic>Ask a public question</TitleBasic>
      <NoticeWrite>
        <strong className="titNw">Writing a good question</strong>
        <p>
          You’re ready to{' '}
          <a href="https://stackoverflow.com/help/how-to-ask">ask</a> a{' '}
          <a href="https://stackoverflow.com/help/on-topic">
            programming-related question
          </a>{' '}
          and this form will help guide you through the process.
        </p>
        <p>
          Looking to ask a non-programming question? See{' '}
          <a href="https://stackexchange.com/sites#technology-traffic">
            the topics here
          </a>{' '}
          to find a relevant site.
        </p>

        <strong className="titStepList">Steps</strong>
        <ul className="listStep">
          <li>Summarize your problem in a one-line title.</li>
          <li>Describe your problem in more detail.</li>
          <li>Describe what you tried and what you expected to happen.</li>
          <li>
            Add “tags” which help surface your question to members of the
            community.
          </li>
          <li>Review your question and post it to the site.</li>
        </ul>
      </NoticeWrite>

      <form onSubmit={handleSubmit}>
        <BoxWrite>
          <div className="contWrite">
            <strong className="titCw">Title</strong>
            <p className="descCw">
              Be specific and imagine you’re asking a question to another
              person.
            </p>
            <div className="txtFiledCw">
              <InpTxt autoComplete="off" value={title} onChange={setTitle} />
            </div>
          </div>
          <div className="tipWrite"></div>
        </BoxWrite>

        <BoxWrite>
          <div className="contWrite">
            <strong className="titCw">
              What are the details of your problem?
            </strong>
            <p className="descCw">
              Introduce the problem and expand on what you put in the title.
              Minimum 20 characters.
            </p>
            <div className="txtFiledCw">
              <InpTxt
                autoComplete="off"
                value={problem}
                onChange={setProblem}
              />
            </div>
          </div>
          <div className="tipWrite"></div>
        </BoxWrite>

        <BoxWrite>
          <div className="contWrite">
            <strong className="titCw">
              What did you try and what were you expecting?
            </strong>
            <p className="descCw">
              Describe what you tried, what you expected to happen, and what
              actually resulted. Minimum 20 characters.
            </p>
            <div className="txtFiledCw">
              <InpTxt autoComplete="off" value={trying} onChange={setTrying} />
            </div>
          </div>
          <div className="tipWrite"></div>
        </BoxWrite>

        <BoxWrite>
          <div className="contWrite">
            <strong className="titCw">Tags</strong>
            <p className="descCw">
              Add up to 5 tags to describe what your question is about. Start
              typing to see suggestions.
            </p>
            <div className="txtFiledCw">
              <InpTxt autoComplete="off" value={tags} onChange={makeSetTag} />
            </div>
          </div>
          <div className="tipWrite"></div>
        </BoxWrite>

        <BtnRow>
          <BtnBasic>
            <button type="submit">save question info</button>
          </BtnBasic>
        </BtnRow>
      </form>
      {loading && <LoadingDiv>Loading...</LoadingDiv>}
    </Wrapper>
  );
};
export default withCookies(Board_inputs);
