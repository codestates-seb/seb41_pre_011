import styled from 'styled-components';
import UserContentsCard from '../components/user/UserContentsCard';
import Paging from '../components/paging/Paging';
import { useState } from 'react';

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
  const [pageData, setPageData] = useState([]);
  // const [searchParams] = useSearchParams();
  // const tagPage = searchParams.get('page');
  const PageLengthData = [...Array(pageData.totalPages)].map((it, idx) => {
    return (it = {
      nowNum: pageData.page === idx + 1 ? true : false,
      num: idx + 1,
    });
  });
  return (
    <Wrapper>
      <User>Users</User>
      <UserContentsCard setPageData={setPageData} />

      <Paging location={'/user_list'} pagingArr={PageLengthData}></Paging>
    </Wrapper>
  );
};
export default User_list;
