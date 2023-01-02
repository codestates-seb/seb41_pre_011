import styled from 'styled-components';

const TitleEl = styled.h2`
  flex: 1;
  font-size: 2.07692308rem;
  font-weight: normal;
  margin-bottom: 16px;
`;

const TitleBasic = ({ children, className }) => {
  return <TitleEl className={className ? className : ''}>{children}</TitleEl>;
};
export default TitleBasic;
