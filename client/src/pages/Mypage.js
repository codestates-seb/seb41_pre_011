import styled from 'styled-components';

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
  margin-top: 2px;
  text-align: left;
`;

const InfoInput = styled.input`
  box-sizing: border-box;
  padding: 0.6em 0.7em;
  width: 421.33px;
  height: 32.8px;
  border: 1px solid hsl(210, 8%, 75%);
  font-size: 13px;
  color: hsl(210, 8%, 5%);
  border-radius: 3px;
  background-color: white;
`;

const Mypage = () => {
  return (
    <Wrapper>
      <Edit>Edit your profile</Edit>
      <Public>Public information</Public>
      <InformationWrapper>
        <ImageDiv>Profile image</ImageDiv>
        <Image src="https://avatars.dicebear.com/api/bottts/1.svg" />
        <InfoDiv>
          <InfoTextDiv>User name</InfoTextDiv>
          <InfoInputDiv>
            <InfoInput></InfoInput>
          </InfoInputDiv>
        </InfoDiv>
        <InfoDiv>
          <InfoTextDiv>Password</InfoTextDiv>
          <InfoInputDiv>
            <InfoInput></InfoInput>
          </InfoInputDiv>
        </InfoDiv>
        <InfoDiv>
          <InfoTextDiv>Email</InfoTextDiv>
          <InfoInputDiv>
            <InfoInput value={'이메일'} disabled></InfoInput>
          </InfoInputDiv>
        </InfoDiv>
      </InformationWrapper>
    </Wrapper>
  );
};
export default Mypage;
