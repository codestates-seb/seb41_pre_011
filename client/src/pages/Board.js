import styled from 'styled-components';

import TitleBasic from '../components/titleBasic/TitleBasic';
import TagBasic from '../components/tagBasic/TagBasic';
import BtnBasic from '../components/btnBasic/BtnBasic';
import { Link, useSearchParams } from 'react-router-dom';
import InpTxt from '../components/inpTxt/InpTxt';
// import { useDispatch, useSelector } from 'react-redux';
import { useEffect, useState } from 'react';
import axios from 'axios';

const Wrapper = styled.div`
  width: 1100px;
  box-sizing: border-box;
  padding: 24px;
  margin: 0 auto;
`;

const TitBoard = styled.div`
  border-bottom: 1px solid rgba(227, 230, 232);
`;

const ContentBoard = styled.div`
  display: flex;

  .mainBar {
    .areaQuestion {
      .descQ {
        padding: 20px 0px;
      }
      .tagsQ {
        display: flex;
        flex-wrap: wrap;
        margin-bottom: 20px;
      }
      .editQ {
        margin-bottom: 20px;
      }
    }

    .areaAnswers {
      border-top: 1px solid #ddd;

      .titA {
        display: block;
        padding: 10px 0;
      }
    }

    .areaWriteAnswer {
      border-top: 1px solid #ddd;
      margin-top: 10px;
      padding: 20px 0;

      .btnRow {
        padding: 10px 0;
      }
    }
  }
`;

const Board = () => {
  const [searchParams] = useSearchParams();
  const questionId = searchParams.get('questionId');
  const [aQuestionData, setAQuestionsData] = useState({});

  useEffect(() => {
    axios
      .get(
        `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/question/${questionId}`
      )
      .then((res) => setAQuestionsData(res.data.data));
  }, []);

  // useEffect(() => {
  //   axios
  //     .get(
  //       `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/answer?questionId=${questionId}`
  //     )
  //     .then((res) => console.log(res.data.data));
  // });

  // const answerData = useSelector((state) => state.AnswerSlice.AnswerDummyData);
  return (
    <Wrapper>
      <TitBoard>
        <TitleBasic>{aQuestionData.title}</TitleBasic>
      </TitBoard>
      <ContentBoard>
        <div className="mainBar">
          <div className="areaQuestion">
            <p className="descQ">
              {aQuestionData.questionContent}
              <br />
              {aQuestionData.attemptContent}
            </p>

            {console.log(aQuestionData.tag)}
            {aQuestionData.tag === null ||
            aQuestionData.tag === undefined ? undefined : (
              <div className="tagsQ">
                {aQuestionData.tag.map((it, idx) => (
                  <TagBasic key={idx}>{it}</TagBasic>
                ))}
              </div>
            )}

            <div className="editQ">
              <Link to={`/board_edit?questionId=${questionId}`}>Edit</Link>
            </div>
          </div>
          <div className="areaAnswers">
            <strong className="titA">Answer</strong>
            {/* <div className="descA">{answerData[questionId - 1].content}</div> */}
          </div>
          <div className="areaWriteAnswer">
            <strong className="titW">Write Answer</strong>
            <form>
              <div>
                <InpTxt autoComplete="off" />
              </div>
              <div className="btnRow">
                <BtnBasic>
                  <button type="submit">Post Your Answer</button>
                </BtnBasic>
              </div>
            </form>
          </div>
        </div>
        <div className="sideBar"></div>
      </ContentBoard>
    </Wrapper>
  );
};
export default Board;
