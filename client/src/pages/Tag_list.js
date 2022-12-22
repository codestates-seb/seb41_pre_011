import styled from 'styled-components';
import TagContentsCard from '../components/tag/TagContentsCard';

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

const Tag_list = () => {
  return (
    <Wrapper>
      <Tag>Tags</Tag>
      <TagInfo>
        A tag is a keyword or label that categorizes your question with other,
        similar questions. Using the right tags makes it easier for others to
        find and answer your question.
      </TagInfo>
      <TagMore>Show all tag synonyms</TagMore>
      <TagContentsCard />
    </Wrapper>
  );
};
export default Tag_list;
