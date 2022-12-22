import styled from 'styled-components';
import TagDummyData from '../../dummy/TagDummyData';

const ContentsWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
  width: 1051px;
  background-color: black;
  justify-content: space-between;
`;

const TagContentsCardBox = styled.div`
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  border: 1px solid hsl(210, 8%, 85%);
  border-radius: 3px;
  padding: 12px;
  width: 255px;
  height: 225px;
  background-color: pink;
  margin-bottom: 10px;
`;

const TagContentsDiv = styled.div`
  margin-bottom: 12px;
`;

const TagContentsButton = styled.button`
  display: flex;
  border: 1px solid hsl(210, 8%, 85%);
  border-radius: 3px;
  padding: 12px;
  font-size: 12px;
  color: hsl(205, 47%, 42%);
  background-color: hsl(205, 46%, 92%);
  padding: 0.4em 0.5em;
  text-align: center;
  height: 30px;
`;

const TagContentsInfo = styled.div`
  display: flex;
  border: 1px solid hsl(210, 8%, 85%);
  border-radius: 3px;
  padding: 12px;
  font-size: 12px;
  color: hsl(210, 8%, 25%);
  background-color: white;
  padding: 0.4em 0.5em;
  text-align: left;
  height: 100px;
`;

const TagContentsQuestionsDiv = styled.div`
  display: flex;
`;

const TagContentQuestions = styled.div`
  background-color: white;
  font-size: 12px;
  color: hsl(210, 8%, 55%);
  text-align: left;
  height: 40px;
  width: 90px;
  margin-left: 150px;
  padding-left: 5px;
  padding-top: 1px;
`;

const TagContentsCard = () => {
  return (
    <ContentsWrapper>
      {TagDummyData.map((it) => (
        <TagContentsCardBox key={it.id}>
          <TagContentsDiv>
            <TagContentsButton>{it.tag}</TagContentsButton>
          </TagContentsDiv>
          <TagContentsDiv>
            <TagContentsInfo>{it.contents}</TagContentsInfo>
          </TagContentsDiv>
          <TagContentsQuestionsDiv>
            <TagContentQuestions>
              {it.questions} <br />
              questions
            </TagContentQuestions>
          </TagContentsQuestionsDiv>
        </TagContentsCardBox>
      ))}
    </ContentsWrapper>
  );
};

export default TagContentsCard;
