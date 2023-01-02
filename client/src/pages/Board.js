import styled from 'styled-components';

import TitleBasic from '../components/titleBasic/TitleBasic';
import TagBasic from '../components/tagBasic/TagBasic';
import BtnBasic from '../components/btnBasic/BtnBasic';
import Sidebar from '../components/sidebar/Sidebar';
import { useSearchParams, useNavigate } from 'react-router-dom';
import InpTxt from '../components/inpTxt/InpTxt';
import { useDispatch, useSelector } from 'react-redux';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { getAnswerData } from '../stateContainer/slice/AnswerSlice';
import { withCookies, Cookies } from 'react-cookie';

const Wrapper = styled.div`
  width: 1100px;
  box-sizing: border-box;
  padding: 24px;
  margin: 0 auto;
`;

const TitBoard = styled.div`
  border-bottom: 1px solid hsl(210, 8%, 80%);
  margin-bottom: 20px;
  padding-bottom: 18px;
`;

const AnswerTitleBasic = styled(TitleBasic)`
  margin-bottom: 4px;
`;

const ListWriteInfo = styled.dl`
  display: flex;
  dt {
    color: rgb(106, 115, 124);
  }
  dd {
    margin-left: 4px;
    color: rgb(35, 38, 41);
  }
  dd + dt {
    margin-left: 14px;
  }
`;

const ContentBoard = styled.div`
  display: flex;

  .mainBar {
    flex: 1;
    .areaQuestion {
      .descQ {
        padding-bottom: 20px;
        color: rgb(35, 38, 41);
        font-size: 15px;
        line-height: 22px;
      }
      .tagsQ {
        display: flex;
        flex-wrap: wrap;
        margin-bottom: 20px;
      }
    }

    .areaAnswers,
    .areaWriteAnswer {
      border-top: 1px solid hsl(210, 8%, 80%);
      margin-top: 20px;
      padding-top: 20px;

      .titA {
        display: block;
        font-size: 18px;
        font-weight: normal;
        margin-bottom: 5px;
      }
    }
    .areaWriteAnswer {
      .btnRow {
        padding: 10px 0;
      }
    }
  }
`;

const MemberRow = styled.div`
  width: 100%;
  display: flex;

  .editMR {
    flex: 1;

    button {
      color: hsl(210, 8%, 45%);
    }
  }

  .memberInfoMR {
    display: flex;
    justify-content: center;
    color: hsl(206, 100%, 40%);

    img {
      width: 16px;
      height: 16px;
      border-radius: 4px;
      box-sizing: border-box;
      border: 1px solid rgba(0, 0, 0, 0.1);
      margin-right: 3px;
    }
  }
`;

const ListAnswer = styled.ul`
  li {
    border-top: 1px solid hsl(210, 8%, 90%);
    margin: 0 10px;
    padding: 10px;
  }

  .descA {
    color: rgb(35, 38, 41);
    font-size: 15px;
    line-height: 22px;
    padding-bottom: 10px;
  }

  dl {
    width: 100%;
    justify-content: flex-end;
    font-size: 11px;
    margin-bottom: 2px;
  }

  .editAnser {
    .rowEditA {
      margin-bottom: 6px;
    }
    .rowBtnA {
      text-align: right;

      .editBtn {
        button {
          padding: 0.5em 1.2em;
        }
      }
    }
  }
`;
// const TagDiv = styled.div`
//   margin-left: 17px;
//   margin-bottom: 5px;
// `;
const DeleteButton = styled.button`
  cursor: pointer;
  height: 100%;
  width: 50px;
  color: red;
`;

const userCookiesData = new Cookies();
const userCookiesGetData = userCookiesData.get('userCookies');

const Board = () => {
  const navigate = useNavigate();
  const [searchParams] = useSearchParams();
  const questionId = searchParams.get('questionId');
  const [aQuestionData, setAQuestionsData] = useState({});
  const dispatch = useDispatch();
  // const [AnswerSliceData, setAnswerSliceData] = useState([...AnswerSliceData1]);
  let AnswerSliceData = useSelector((state) => state.AnswerSlice.AnswerData);
  const [writeAnswer, setWriteAnswer] = useState('');
  // const [reRender, setReRender] = useState(questionId);
  // const handleAnswer = () => {
  //   axios;
  //   .post(
  //     `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/answer`
  //   )
  //   .then((res) => console.log(res.data));
  //   navigate(`/board?questionId=${questionId}`);
  // };

  const handleButton = () => {
    if (userCookiesGetData === undefined) {
      navigate('/login');
    } else {
      navigate(`/board_edit?questionId=${questionId}`);
    }
  };

  const handleLink = (answerId) => {
    if (userCookiesGetData === undefined) {
      navigate('/login');
    } else {
      navigate(`/answer_edit?questionId=${questionId}&answerId=${answerId}`);
    }
  };

  const handleDelete = (answerId) => {
    if (userCookiesGetData === undefined) {
      navigate('/login');
    } else {
      axios
        .delete(
          `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/answer/${answerId}`,
          {
            headers: {
              Authorization: userCookiesGetData.authorization,
            },
          }
        )
        .then((res) => {
          if (res.status === 204) {
            const AAA = AnswerSliceData.filter((it) => {
              return it.answerId !== answerId;
            });
            dispatch(getAnswerData([...AAA]));
            // window.location.replace(`/board?questionId=${questionId}`);
          }
        });
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const userCookiesData = new Cookies();
    console.log(userCookiesData.get('userCookies'));
    const userCookiesGetData = userCookiesData.get('userCookies');
    if (userCookiesGetData === undefined) {
      navigate('/login');
    } else {
      axios
        .post(
          `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/answer`,
          {
            questionId: questionId,
            content: writeAnswer,
            // tags: ['javascript', 'java', 'html'],
          },
          {
            headers: {
              Authorization: userCookiesGetData.authorization,
            },
          }
        )
        .then((res) => {
          if (res.status === 201) {
            dispatch(getAnswerData([...AnswerSliceData, res.data.data]));
            // window.location.replace(`/board?questionId=${questionId}`);
            setWriteAnswer('');
          }
        });
    }
  };

  useEffect(() => {
    axios
      .get(
        `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/question/${questionId}`
      )
      .then((res) => setAQuestionsData(res.data.data));
  }, []);

  useEffect(() => {
    axios
      .get(
        `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/answer?questionId=${questionId}`
      )
      .then((res) => dispatch(getAnswerData(res.data.data)));
  }, []);
  return (
    <Wrapper>
      <TitBoard>
        <AnswerTitleBasic>{aQuestionData.title}</AnswerTitleBasic>
        <ListWriteInfo>
          <dt>Asked</dt>
          <dd>{aQuestionData.createdDate}</dd>
          <dt>Modified</dt>
          <dd>{aQuestionData.modifiedDate}</dd>
        </ListWriteInfo>
      </TitBoard>
      <ContentBoard>
        <div className="mainBar">
          <div className="areaQuestion">
            <p className="descQ">
              {aQuestionData.questionContent}
              <br />
              <br />
              {aQuestionData.attemptContent}
            </p>

            {aQuestionData.tags === null ||
            aQuestionData.tags === undefined ? undefined : (
              <div className="tagsQ">
                {aQuestionData.tags.map((it, idx) => (
                  <TagBasic key={idx}>{it}</TagBasic>
                ))}
              </div>
            )}

            <MemberRow>
              <div className="editMR">
                <button type="button" onClick={handleButton}>
                  Edit
                </button>
              </div>
              <div className="memberInfoMR">
                <img src={aQuestionData.memberImage} alt="" />
                <span>
                  <span className="blind">작성자 :</span>
                  {aQuestionData.memberName}
                </span>
              </div>
            </MemberRow>
          </div>
          <div className="areaAnswers">
            <strong className="titA">Answer</strong>

            {AnswerSliceData.map((it) => (
              <ListAnswer key={it.answerId}>
                <li>
                  <div className="contAnswer">
                    <p className="descA">{it.content}</p>
                    <ListWriteInfo>
                      <dt>Created : </dt>
                      <dd>{it.createdDate}</dd>
                      <dt>Modified : </dt>
                      <dd>{it.modifiedDate}</dd>
                    </ListWriteInfo>

                    <MemberRow>
                      <div className="editMR">
                        <button
                          type="button"
                          onClick={() => {
                            handleLink(it.answerId);
                          }}
                        >
                          Edit
                        </button>
                      </div>
                      <DeleteButton
                        type="button"
                        onClick={() => {
                          handleDelete(it.answerId);
                        }}
                      >
                        Delete
                      </DeleteButton>
                      <div className="memberInfoMR">
                        <img src={it.memberImage} alt="" />
                        <span>
                          <span className="blind">작성자 :</span>
                          {it.memberName}
                        </span>
                      </div>
                    </MemberRow>
                  </div>
                  <div className="editAnser"></div>
                </li>
                {/* {it.tags === null || it.tags === undefined ? undefined : (
                  <TagDiv>
                    <div className="tagsQ">
                      {it.tags.map((it, idx) => (
                        <TagBasic key={idx}>{it}</TagBasic>
                      ))}
                    </div>
                  </TagDiv>
                )} */}
              </ListAnswer>
            ))}
          </div>
          <div className="areaWriteAnswer">
            <strong className="titA">Write Answer</strong>

            <form onSubmit={handleSubmit}>
              <div>
                <InpTxt
                  autoComplete="off"
                  value={writeAnswer}
                  onChange={setWriteAnswer}
                />
              </div>
              <div className="btnRow">
                <BtnBasic>
                  <button type="submit">Post Your Answer</button>
                </BtnBasic>
              </div>
            </form>
          </div>
        </div>
        {/* <div>{reRender}</div> */}
        <Sidebar />
      </ContentBoard>
    </Wrapper>
  );
};
export default withCookies(Board);
