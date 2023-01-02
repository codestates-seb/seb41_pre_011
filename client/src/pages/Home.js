import styled from 'styled-components';
import TitleBasic from '../components/titleBasic/TitleBasic';
import stone from '../assets/stone.jpg';

const Wrapper = styled.div`
  width: 1100px;
  box-sizing: border-box;
  padding: 24px;
  margin: 0 auto;
  display: flex;
`;
const TitleDiv = styled.div`
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;
  width: 100%;
`;
const StoneImg = styled.img`
  border-radius: 20%;
  width: 400px;
  display: block;
  margin: 30px auto;
`;

const Home = () => {
  return (
    <Wrapper>
      <TitleDiv>
        <TitleBasic>Welcome to 11 stone 2 birds Stack Overflow!</TitleBasic>
        <h1>You are free to post questions and answers</h1>
        <h1>Have a good time :{')'}</h1>
        <StoneImg src={stone} alt="돌맹이" />
      </TitleDiv>
    </Wrapper>
  );
};
export default Home;
