import styled from 'styled-components';
import UserDummyData from '../../dummy/UserDummyData';
import { useState, useEffect } from 'react';
// import axios from 'axios';

const UserWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
  width: 1051px;
  background-color: black;
  justify-content: space-between;
`;

const UserContentsCardBox = styled.div`
  box-sizing: border-box;
  display: flex;
  padding: 5px 6px 7px 7px;
  background-color: pink;
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
  color: 0074cc;
  font-size: 17px;
  margin-left: 2px;
`;

const Email = styled.div`
  color: hsl(210, 8%, 45%);
  font-size: 13px;
  margin-top: 2px;
  margin-left: 2px;
`;

const UserContentsCard = () => {
  const [data, setData] = useState([]);
  useEffect(() => {
    setData(UserDummyData);

    // axios.get('/v1/member/1').then((res) => setData(res.data));
    // axios
    //   .post('/v1/member/1', {
    //     email: 'hgd@gmail.com',
    //     name: '홍길동',
    //     password: 'Code^States1',
    //   })
    //   .then((res) => setData(res.data))
    //   .catch((error) => console.log('error : ', error));
  }, []);

  console.log(data);
  return (
    <UserWrapper>
      {data.map((it) => (
        <UserContentsCardBox key={it.id}>
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
