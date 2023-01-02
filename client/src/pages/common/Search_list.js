import styled from 'styled-components';
import TitleBasic from '../../components/titleBasic/TitleBasic';
import BtnBasic from '../../components/btnBasic/BtnBasic';
import TagBasic from '../../components/tagBasic/TagBasic';
import Sidebar from '../../components/sidebar/Sidebar';
import Paging from '../../components/paging/Paging';
import { Link, useSearchParams, useNavigate } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { useEffect } from 'react';
import axios from 'axios';
import { withCookies, Cookies } from 'react-cookie';
import {
  getQuestionsData,
  getQpagingData,
} from '../../stateContainer/slice/QuestionsSlice';

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

const Search_list = () => {
  const [searchParams] = useSearchParams();
  let nowPageNum = searchParams.get('page');
  const navigate = useNavigate();

  const dispatch = useDispatch();
  const QuestionsSliceData = useSelector(
    (state) => state.QuestionsSlice.QuestionsData
  );
  const QuestionsSlicePagingData = useSelector(
    (state) => state.QuestionsSlice.QpagingData
  );
  const pagingArr = [...Array(QuestionsSlicePagingData.totalPages)].map(
    (v, i) => {
      return (v = {
        nowNum: QuestionsSlicePagingData.page === i + 1 ? true : false,
        num: i + 1,
      });
    }
  );
  const handleButton = () => {
    const userCookiesData = new Cookies();
    console.log(userCookiesData.get('userCookies'));
    const userCookiesGetData = userCookiesData.get('userCookies');
    if (userCookiesGetData === undefined) {
      navigate('/login');
    } else {
      navigate('/board_write');
    }
  };

  useEffect(() => {
    const updateQuestionsData = () => {
      try {
        axios
          .get(
            `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/question?page=${nowPageNum}&size=8`
          )
          .then((res) => {
            dispatch(getQuestionsData(res.data.data));
            dispatch(getQpagingData(res.data.pageInfo));
          });
      } catch (error) {
        console.error(error);
      }
    };
    updateQuestionsData(nowPageNum);
  }, [nowPageNum]);

  return (
    <Wrapper>
      <MainBar>
        <div className="rowMB">
          <TitleBasic>Questions</TitleBasic>
          <BtnBasic>
            <button type="button" onClick={handleButton}>
              Ask Question
            </button>
          </BtnBasic>
        </div>
        <div className="rowMB">
          <span className="infoQuestions">
            {QuestionsSlicePagingData.totalElements} questions
          </span>
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
        <Paging location={'/board_list'} pagingArr={pagingArr}></Paging>
      </MainBar>

      <Sidebar />
    </Wrapper>
  );
};
export default withCookies(Search_list);
