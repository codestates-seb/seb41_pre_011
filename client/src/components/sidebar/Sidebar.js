import styled from 'styled-components';
const SideBarEl = styled.div`
  width: 300px;
  height: 460px;
  margin-left: 24px;
  background-color: rgb(253, 247, 226);
`;

const LeftBoxDiv = styled.div`
  width: 268px;
  height: 15.688px;
  padding: 12px 15px;
  background-color: rgb(251, 243, 213);
  font-size: 12px;
  border: 1px solid hsl(47, 65%, 84%);
  color: hsl(210, 8%, 35%);
  font-weight: 700;
`;

const LeftBoxInDiv = styled.div`
  color: rgb(35, 38, 41);
  font-size: 13px;
  padding-left: 16px;
  padding-right: 16px;
  margin-top: 12px;
  margin-bottom: 12px;
  width: 266px;
  display: flex;
  flex-direction: row;
`;

const LeftBoxContentDiv = styled.div`
  width: 100%;
  padding-left: 6px;
`;

const IconTalk = styled.span`
  width: 16px;
  height: 16px;
  background-position: 0 -6120px;
  margin-top: 5px;
`;

const StackIcon = styled.span`
  width: 16px;
  height: 16px;
  background-position: 0 -6156px;
  margin-top: 3px;
`;

const EightSpan = styled.span`
  color: hsl(210, 8%, 45%);
  width: 7.01;
  height: 15.2;
`;

const Sidebar = () => {
  return (
    <SideBarEl>
      <LeftBoxDiv>The Overflow Blog</LeftBoxDiv>
      <LeftBoxInDiv>
        <svg
          aria-hidden="true"
          className="va-text-top svg-icon iconPencilSm"
          width="14"
          height="14"
          viewBox="0 0 14 14"
        >
          <path d="m11.1 1.71 1.13 1.12c.2.2.2.51 0 .71L11.1 4.7 9.21 2.86l1.17-1.15c.2-.2.51-.2.71 0ZM2 10.12l6.37-6.43 1.88 1.88L3.88 12H2v-1.88Z"></path>
        </svg>{' '}
        <LeftBoxContentDiv>
          Picture perfect images with the modern {'<img>'} element
        </LeftBoxContentDiv>
      </LeftBoxInDiv>
      <LeftBoxInDiv>
        <svg
          aria-hidden="true"
          className="va-text-top svg-icon iconPencilSm"
          width="14"
          height="14"
          viewBox="0 0 14 14"
        >
          <path d="m11.1 1.71 1.13 1.12c.2.2.2.51 0 .71L11.1 4.7 9.21 2.86l1.17-1.15c.2-.2.51-.2.71 0ZM2 10.12l6.37-6.43 1.88 1.88L3.88 12H2v-1.88Z"></path>
        </svg>
        <LeftBoxContentDiv>
          The Great Resignation is here. What does that mean for developers?
        </LeftBoxContentDiv>
      </LeftBoxInDiv>
      <LeftBoxDiv>Featured on Meta</LeftBoxDiv>

      <LeftBoxInDiv>
        <IconTalk className="icoFavi">
          <span className="blind">말풍선</span>
        </IconTalk>
        <LeftBoxContentDiv>
          Navigation and UI research starting soon
        </LeftBoxContentDiv>
      </LeftBoxInDiv>

      <LeftBoxInDiv>
        <StackIcon className="icoFavi">
          <span className="blind">쌓는 아이콘</span>
        </StackIcon>
        <LeftBoxContentDiv>
          2022 Community Moderator Election Results - now with two more mods!
        </LeftBoxContentDiv>
      </LeftBoxInDiv>

      <LeftBoxInDiv>
        <StackIcon className="icoFavi">
          <span className="blind">쌓는 아이콘</span>
        </StackIcon>
        <LeftBoxContentDiv>
          Temporary policy: ChatGPT is banned
        </LeftBoxContentDiv>
      </LeftBoxInDiv>

      <LeftBoxInDiv>
        <StackIcon className="icoFavi">
          <span className="blind">쌓는 아이콘</span>
        </StackIcon>
        <LeftBoxContentDiv>
          I{"'"}m standing down as a moderator
        </LeftBoxContentDiv>
      </LeftBoxInDiv>

      <LeftBoxDiv>The Overflow Blog</LeftBoxDiv>
      <LeftBoxInDiv>
        <EightSpan>8</EightSpan>
        <LeftBoxContentDiv>
          Can we remove or merge tag [whatsapi] with tag [whatsapp]?
        </LeftBoxContentDiv>
      </LeftBoxInDiv>
    </SideBarEl>
  );
};

export default Sidebar;
