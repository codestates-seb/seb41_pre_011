import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import axios from 'axios';

import styled from 'styled-components';
import InpTxt from '../components/inpTxt/InpTxt';
import BtnBasic from '../components/btnBasic/BtnBasic';
import LoadingDiv from '../components/loading/Loading';

const Wrapper = styled.div`
  width: 1100px;
  box-sizing: border-box;
  padding: 16px;
  margin: 0 auto;
`;
const Edit = styled.div`
  padding-bottom: 16px;
  margin-bottom: 24px;
  font-size: 2.07692308rem;
  border-bottom: 1px solid hsl(210, 8%, 85%);
  color: hsl(210, 8%, 5%);
`;

const Public = styled.div`
  font-size: 1.61538462rem;
  margin-bottom: 8px;
  text-align: left;
`;

const InformationWrapper = styled.div`
  padding: 24px;
  margin-bottom: 48px;
  border: 1px solid hsl(210, 8%, 90%);
  border-radius: 5px;
  text-align: left;
  display: flex;
  flex-direction: column;
`;

const ImageDiv = styled.div`
  text-align: left;
  align-items: center;
  color: hsl(210, 8%, 5%);
  font-size: 1.15384615rem;
  font-weight: 600;
  cursor: pointer;
`;

const Image = styled.img`
  margin-top: 5px;
  width: 164px;
  height: 164px;
  border-radius: 3px;
`;

const InfoDiv = styled.div`
  /* margin: 4px; */
  margin-top: 6px;
  margin-bottom: 6px;
  text-align: left;
`;

const InfoTextDiv = styled.div`
  cursor: pointer;
  font-size: 1.15384615rem;
  color: hsl(210, 8%, 5%);
  font-weight: 600;
`;

const InfoInputDiv = styled.div`
  width: 420px;
  margin-top: 2px;
  text-align: left;
`;

const Mypage = () => {
  const [name, setName] = useState('');
  const [password, setPassword] = useState('');
  const [email, setEmail] = useState('');
  const [image, setImage] = useState('');
  const [loading, setLoading] = useState(false);

  const [searchParams] = useSearchParams();
  const userEmail = searchParams.get('userEmail');

  console.log(userEmail);

  useEffect(() => {
    axios
      .get(
        `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/member/${userEmail}`
      )
      .then((res) => {
        setName(res.data.data.name);
        setEmail(res.data.data.email);
        setImage(res.data.data.image);
      });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    setLoading(true);
    setTimeout(() => {
      try {
        axios
          .patch(
            `http://ec2-13-209-138-5.ap-northeast-2.compute.amazonaws.com:8080/v1/member/${userEmail}`,
            {
              name: name,
              password: password,
            },
            { withCredentials: true }
          )
          .then((res) => {
            setName(res.data.data.name);
            setEmail(res.data.data.email);
          })
          .then(setLoading(false))
          .then(alert('수정 되었습니다'));
        //navigate('/board_list');
      } catch (error) {
        console.log(error);
      }
    }, 2000);
  };

  return (
    <Wrapper>
      <Edit>Edit your profile</Edit>
      <Public>Public information</Public>
      <form onSubmit={handleSubmit}>
        <InformationWrapper>
          <ImageDiv>Profile image</ImageDiv>
          <Image src={image} />
          <InfoDiv>
            <InfoTextDiv>User name</InfoTextDiv>
            <InfoInputDiv>
              <InpTxt
                htmlId="name"
                autoComplete="off"
                value={name}
                onChange={setName}
              />
            </InfoInputDiv>
          </InfoDiv>
          <InfoDiv>
            <InfoTextDiv>Password</InfoTextDiv>
            <InfoInputDiv>
              <InpTxt
                autoComplete="off"
                htmlId="password"
                value={password}
                onChange={setPassword}
              />
            </InfoInputDiv>
          </InfoDiv>
          <InfoDiv>
            <InfoTextDiv>Email</InfoTextDiv>
            <InfoInputDiv>
              <InpTxt
                htmlId="email"
                utoComplete="off"
                value={email}
                readonly={true}
              />
            </InfoInputDiv>
          </InfoDiv>
          <InfoDiv>
            <BtnBasic>
              <button type="submit">save member info</button>
            </BtnBasic>
          </InfoDiv>
        </InformationWrapper>
      </form>
      {loading && <LoadingDiv>Loading...</LoadingDiv>}
    </Wrapper>
  );
};
export default Mypage;
