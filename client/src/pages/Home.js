import styled from 'styled-components';
import TitleBasic from '../components/titleBasic/TitleBasic';

const Wrapper = styled.div`
  width: 1100px;
  box-sizing: border-box;
  padding: 24px;
  margin: 0 auto;
  display: flex;
`;

const Home = () => {
  return (
    <Wrapper>
      <TitleBasic>Stack Overflow</TitleBasic>
    </Wrapper>
  );
};
export default Home;
