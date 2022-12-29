import styled from 'styled-components';
import { useState, useEffect } from 'react';
import axios from 'axios';

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
  const [data, setData] = useState([]);
  useEffect(() => {
    try {
      axios
        .get(
          'http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/tag?page=1&size=16'
        )
        .then((res) => setData(res.data.data));
    } catch (error) {
      console.error(error);
    }
  }, []);
  return (
    <ContentsWrapper>
      {data.map((it) => (
        <TagContentsCardBox key={it.tagId}>
          <TagContentsDiv>
            <TagContentsButton>{it.name}</TagContentsButton>
          </TagContentsDiv>
          <TagContentsDiv>
            <TagContentsInfo>{it.description}</TagContentsInfo>
          </TagContentsDiv>
          <TagContentsQuestionsDiv>
            <TagContentQuestions>
              {it.count} <br />
              questions
            </TagContentQuestions>
          </TagContentsQuestionsDiv>
        </TagContentsCardBox>
      ))}
    </ContentsWrapper>
  );
};

export default TagContentsCard;
