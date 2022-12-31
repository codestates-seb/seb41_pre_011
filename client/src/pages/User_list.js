import styled from 'styled-components';
import UserContentsCard from '../components/user/UserContentsCard';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

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
  &.on {
    color: #fff;
    background-color: rgb(244, 130, 37);
    border-color: rgb(244, 130, 37);
  }
`;

const User_list = () => {
  const [pageData, setPageData] = useState([]);
  // const [searchParams] = useSearchParams();
  // const tagPage = searchParams.get('page');
  console.log(pageData);
  const PageLengthData = [...Array(pageData.totalPages)].map((it, idx) => {
    return (it = {
      nowNum: pageData.page === idx + 1 ? true : false,
      id: idx + 1,
    });
  });
  const navigate = useNavigate();
  return (
    <Wrapper>
      <User>Users</User>
      <UserContentsCard setPageData={setPageData} />
      <PageNumberDiv>
        {PageLengthData.map((it) => (
          <PageNumberButton
            className={it.nowNum ? 'on' : ''}
            key={it.id}
            onClick={() => {
              navigate(`/user_list?page=${it.id}`);
            }}
          >
            {it.id}
          </PageNumberButton>
        ))}
      </PageNumberDiv>
    </Wrapper>
  );
};
export default User_list;
