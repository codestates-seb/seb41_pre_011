import styled from 'styled-components';

import TitleBasic from '../components/titleBasic/TitleBasic';
import TagBasic from '../components/tagBasic/TagBasic';
import BtnBasic from '../components/btnBasic/BtnBasic';
import { Link, useSearchParams } from 'react-router-dom';
import InpTxt from '../components/inpTxt/InpTxt';

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
  console.log(questionId);
  return (
    <Wrapper>
      <TitBoard>
        <TitleBasic>
          Request flow when AWS WAF, ALB associated and ALB 4xx
        </TitleBasic>
      </TitBoard>
      <ContentBoard>
        <div className="mainBar">
          <div className="areaQuestion">
            <p className="descQ">
              We have a server configured under a ALB associated with a WAFAs
              the underlying service receives requests for your web sites, it
              forwards those requests to AWS WAF for inspection against your
              rules.
            </p>

            <div className="tagsQ">
              <TagBasic>javascript</TagBasic>
              <TagBasic>api</TagBasic>
              <TagBasic>java</TagBasic>
            </div>
            <div className="editQ">
              <Link to="/board_edit">Edit</Link>
            </div>
          </div>
          <div className="areaAnswers">
            <strong className="titA">Answer</strong>
            <div className="descA">
              답변 글 답변 글 답변 글 답변 글 답변 글 답변 글 답변 글 답변 글
              답변 글 답변 글 답변 글 답변 글 답변 글 답변 글 답변 글 답변 글
              답변 글 답변 글 답변 글 답변 글 답변 글 답변 글 답변 글 답변 글
              답변 글 답변 글 답변 글 답변 글 답변 글 답변 글 답변 글 답변 글
              답변 글 답변 글
            </div>
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
