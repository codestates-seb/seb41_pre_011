import styled from 'styled-components';
import { useState, useEffect } from 'react';
import axios from 'axios';
import { useSearchParams } from 'react-router-dom';

const UserWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
  width: 1051px;
  justify-content: space-between;
`;

const UserContentsCardBox = styled.div`
  box-sizing: border-box;
  display: flex;
  padding: 5px 6px 7px 7px;
  width: 255px;
  height: 100px;
  margin-bottom: 10px;
`;

const UserImage = styled.img`
  width: 80px;
  height: 80px;
`;

const UserDetails = styled.div`
  margin-left: 9px;
  color: hsl(210, 8%, 45%);
  text-align: left;
`;

const UserName = styled.div`
  color: rgb(0, 116, 204);
  font-size: 17px;
  margin-left: 2px;
`;

const Email = styled.div`
  color: hsl(210, 8%, 45%);
  font-size: 13px;
  margin-top: 2px;
  margin-left: 2px;
  font-weight: bold;
`;

const UserContentsCard = ({ setPageData }) => {
  const [searchParams] = useSearchParams();
  const pageNumber = searchParams.get('page');
  const [data, setData] = useState([]);
  useEffect(() => {
    try {
      axios
        .get(
          `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/member?page=${pageNumber}&size=16`
        )
        .then((res) => {
          setData(res.data.data);
          return res;
        })
        .then((res) => setPageData(res.data.pageInfo));
    } catch (error) {
      console.log(error);
    }
  }, [pageNumber]);

  return (
    <UserWrapper>
      {data.map((it) => (
        <UserContentsCardBox key={it.memberId}>
          <UserImage src={`${it.image}`} />
          <UserDetails>
            <UserName>{it.name}</UserName>
            <Email>{it.email}</Email>
          </UserDetails>
        </UserContentsCardBox>
      ))}
    </UserWrapper>
  );
};

export default UserContentsCard;
