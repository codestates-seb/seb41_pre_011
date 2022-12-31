import styled from 'styled-components';
import TagContentsCard from '../components/tag/TagContentsCard';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Wrapper = styled.div`
  width: 1100px;
  box-sizing: border-box;
  padding: 24px;
  margin: 0 auto;
`;
const Tag = styled.div`
  font-size: 2.07692308rem;
  margin-bottom: 16px;
`;

const TagInfo = styled.div`
  font-size: 1.15384615rem;
  margin-bottom: 16px;
  width: 632;
`;

const TagMore = styled.div`
  font-size: 13px;
  margin-bottom: 24px;
  display: flex;
  align-items: center;
  color: #0074cc;
`;

const PageNumberDiv = styled.div`
  text-align: center;
  margin-top: 20px;
`;
const PageNumberButton = styled.button`
  border: solid 1px rgb(214, 217, 220);
  padding-left: 8px;
  padding-right: 8px;
  color: rgb(59, 67, 69);
  cursor: pointer;
  font-size: 13px;
  margin-left: 5px;

  &:hover {
    background-color: rgba(160, 160, 160, 0.2);
  }
`;

const Tag_list = () => {
  const [pageData, setPageData] = useState([]);
  // const [searchParams] = useSearchParams();
  // const tagPage = searchParams.get('page');
  const PageLengthData = [...Array(pageData)].map((it, idx) => {
    return (it = {
      // nowNum: QuestionsSlicePagingData.page === idx + 1 ? true : false,
      id: idx + 1,
    });
  });
  const navigate = useNavigate();
  return (
    <Wrapper>
      <Tag>Tags</Tag>
      <TagInfo>
        A tag is a keyword or label that categorizes your question with other,
        similar questions. Using the right tags makes it easier for others to
        find and answer your question.
      </TagInfo>
      <TagMore>Show all tag synonyms</TagMore>
      <TagContentsCard setPageData={setPageData} />
      <PageNumberDiv>
        {PageLengthData.map((it) => (
          <PageNumberButton
            key={it.id}
            onClick={() => {
              navigate(`/tag_list?page=${it.id}`);
            }}
          >
            {it.id}
          </PageNumberButton>
        ))}
      </PageNumberDiv>
    </Wrapper>
  );
};
export default Tag_list;
