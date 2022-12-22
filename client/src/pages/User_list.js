import styled from 'styled-components';
import UserContentsCard from '../components/user/UserContentsCard';

const Wrapper = styled.div`
  width: 1100px;
  box-sizing: border-box;
  padding: 24px;
  margin: 0 auto;
`;
const User = styled.div`
  font-size: 2.07692308rem;
  margin-bottom: 24px;
`;

const User_list = () => {
  return (
    <Wrapper>
      <User>Users</User>
      <UserContentsCard />
    </Wrapper>
  );
};
export default User_list;
