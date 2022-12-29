import styled from 'styled-components';
import TitleBasic from '../../components/titleBasic/TitleBasic';
import BtnBasic from '../../components/btnBasic/BtnBasic';
import TagBasic from '../../components/tagBasic/TagBasic';
import { Link } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { useEffect } from 'react';
import axios from 'axios';
import { getQuestionsData } from '../../stateContainer/slice/QuestionsSlice';

const Wrapper = styled.div`
  width: 1100px;
  box-sizing: border-box;
  padding: 24px;
  margin: 0 auto;
  display: flex;
`;

const MainBar = styled.div`
  flex: 1;

  .rowMB {
    display: flex;
  }

  .infoQuestions {
    margin-bottom: 12px;
    font-size: 1.30769231rem;
  }
`;

const ListQuestion = styled.ul`
  padding-bottom: 20px;
  border-top: 1px solid hsl(210, 8%, 90%);
`;

const ItemQuestion = styled.li`
  display: flex;
  border-bottom: 1px solid hsl(210, 8%, 90%);
  padding: 16px;

  .postState {
    width: 108px;
    padding-top: 4px;
    margin: 0 16px 4px;
    text-align: right;
    color: hsl(210, 8%, 45%);
    display: flex;
    flex-direction: column;
    flex-shrink: 0;
    flex-wrap: wrap;
    align-items: flex-end;
    gap: 6px;

    .value {
      font-weight: 500;
      margin-right: 4px;
    }

    .voteState {
      color: hsl(210, 8%, 5%);
    }
  }

  .postContent {
    .titPc {
      display: block;
      padding-right: 24px;
      margin-bottom: 0.3846rem;

      a {
        color: hsl(206, 100%, 40%);
        cursor: pointer;
        word-break: break-all;
        font-size: 17px;
      }
      a:hover {
        color: hsl(206, 100%, 52%);
      }
    }

    .descPc {
      color: hsl(210, 8%, 25%);
      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
      overflow: hidden;
      word-break: break-all;
      text-overflow: ellipsis;
      line-height: 17px;
      max-height: 34px;
      margin-bottom: 8px;
    }

    .tagPc {
      display: flex;
      flex-wrap: wrap;
    }
  }
`;

const LeftBoxDiv = styled.div`
  width: 268px;
  height: 15.688px;
  padding: 12px 15px;
  background-color: rgb(251, 243, 213);
  font-size: 12px;
  border: 1px solid hsl(47, 65%, 84%);
  color: hsl(210, 8%, 35%);
  font-weight: 700;
`;

const LeftBoxInDiv = styled.div`
  color: rgb(35, 38, 41);
  font-size: 13px;
  padding-left: 16px;
  padding-right: 16px;
  margin-top: 12px;
  margin-bottom: 12px;
  width: 266px;
  display: flex;
  flex-direction: row;
`;

const LeftBoxContentDiv = styled.div`
  width: 100%;
  padding-left: 6px;
`;

const IconTalk = styled.span`
  width: 16px;
  height: 16px;
  background-position: 0 -6120px;
  margin-top: 5px;
`;

const StackIcon = styled.span`
  width: 16px;
  height: 16px;
  background-position: 0 -6156px;
  margin-top: 3px;
`;

const EightSpan = styled.span`
  color: hsl(210, 8%, 45%);
  width: 7.01;
  height: 15.2;
`;

const SideBar = styled.div`
  width: 300px;
  height: 460px;
  margin-left: 24px;
  background-color: rgb(253, 247, 226);
`;

const Search_list = () => {
  const dispatch = useDispatch();
  const QuestionsSliceData = useSelector(
    (state) => state.QuestionsSlice.QuestionsData
  );

  useEffect(() => {
    const updateQuestionsData = () => {
      try {
        axios
          .get(
            'http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/question?page=1&size=30'
          )
          .then((res) => {
            return dispatch(getQuestionsData(res.data.data));
          });
      } catch (error) {
        console.error(error);
      }
    };
    updateQuestionsData();
  }, []);

  return (
    <Wrapper>
      <MainBar>
        <div className="rowMB">
          <TitleBasic>Questions</TitleBasic>
          <BtnBasic>
            <Link to="/board_write">Ask Question</Link>
          </BtnBasic>
        </div>
        <div className="rowMB">
          <span className="infoQuestions">23,356,349 questions</span>
        </div>
        <ListQuestion>
          {QuestionsSliceData.map((it) => (
            <ItemQuestion key={it.questionId}>
              <div className="postState">
                <div className="voteState">
                  <span className="value">{it.likes}</span>
                  <span className="txt">votes</span>
                </div>
                <div className="answersState">
                  <span className="value">0</span>
                  <span className="txt">answers</span>
                </div>
                {/* <div className="viewsState">
                  <span className="value">0</span>
                  <span className="txt">views</span>
                </div> */}
              </div>
              <div className="postContent">
                <strong className="titPc">
                  <Link
                    to={`/board?questionId=${it.questionId}`}
                    className="linkPc"
                  >
                    {it.title}
                  </Link>
                </strong>
                <p className="descPc">
                  {it.questionContent} {it.attemptContent}
                </p>
                {it.tags !== null && (
                  <div className="tagPc">
                    {it.tags.map((it, idx) => (
                      <TagBasic key={idx}>{it}</TagBasic>
                    ))}
                  </div>
                )}
              </div>
            </ItemQuestion>
          ))}
        </ListQuestion>
      </MainBar>

      <SideBar>
        <LeftBoxDiv>The Overflow Blog</LeftBoxDiv>
        <LeftBoxInDiv>
          <svg
            aria-hidden="true"
            className="va-text-top svg-icon iconPencilSm"
            width="14"
            height="14"
            viewBox="0 0 14 14"
          >
            <path d="m11.1 1.71 1.13 1.12c.2.2.2.51 0 .71L11.1 4.7 9.21 2.86l1.17-1.15c.2-.2.51-.2.71 0ZM2 10.12l6.37-6.43 1.88 1.88L3.88 12H2v-1.88Z"></path>
          </svg>{' '}
          <LeftBoxContentDiv>
            Picture perfect images with the modern {'<img>'} element
          </LeftBoxContentDiv>
        </LeftBoxInDiv>
        <LeftBoxInDiv>
          <svg
            aria-hidden="true"
            className="va-text-top svg-icon iconPencilSm"
            width="14"
            height="14"
            viewBox="0 0 14 14"
          >
            <path d="m11.1 1.71 1.13 1.12c.2.2.2.51 0 .71L11.1 4.7 9.21 2.86l1.17-1.15c.2-.2.51-.2.71 0ZM2 10.12l6.37-6.43 1.88 1.88L3.88 12H2v-1.88Z"></path>
          </svg>
          <LeftBoxContentDiv>
            The Great Resignation is here. What does that mean for developers?
          </LeftBoxContentDiv>
        </LeftBoxInDiv>
        <LeftBoxDiv>Featured on Meta</LeftBoxDiv>

        <LeftBoxInDiv>
          <IconTalk className="icoFavi">
            <span className="blind">말풍선</span>
          </IconTalk>
          <LeftBoxContentDiv>
            Navigation and UI research starting soon
          </LeftBoxContentDiv>
        </LeftBoxInDiv>

        <LeftBoxInDiv>
          <StackIcon className="icoFavi">
            <span className="blind">쌓는 아이콘</span>
          </StackIcon>
          <LeftBoxContentDiv>
            2022 Community Moderator Election Results - now with two more mods!
          </LeftBoxContentDiv>
        </LeftBoxInDiv>

        <LeftBoxInDiv>
          <StackIcon className="icoFavi">
            <span className="blind">쌓는 아이콘</span>
          </StackIcon>
          <LeftBoxContentDiv>
            Temporary policy: ChatGPT is banned
          </LeftBoxContentDiv>
        </LeftBoxInDiv>

        <LeftBoxInDiv>
          <StackIcon className="icoFavi">
            <span className="blind">쌓는 아이콘</span>
          </StackIcon>
          <LeftBoxContentDiv>
            I{"'"}m standing down as a moderator
          </LeftBoxContentDiv>
        </LeftBoxInDiv>

        <LeftBoxDiv>The Overflow Blog</LeftBoxDiv>
        <LeftBoxInDiv>
          <EightSpan>8</EightSpan>
          <LeftBoxContentDiv>
            Can we remove or merge tag [whatsapi] with tag [whatsapp]?
          </LeftBoxContentDiv>
        </LeftBoxInDiv>
      </SideBar>
    </Wrapper>
  );
};
export default Search_list;
