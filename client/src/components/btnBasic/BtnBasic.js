import styled from 'styled-components';

const BtnBasicEl = styled.span`
  display: inline-block;
  vertical-align: top;

  button,
  a {
    display: block;
    box-sizing: border-box;
    padding: 0.8em;
    background-color: hsl(206, 100%, 52%);
    color: hsl(205, 53%, 98%);
    border: 1px solid hsl(206, 100%, 52%);
    border-radius: 3px;
    cursor: pointer;
    box-shadow: inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
  }
  button:hover,
  a:hover {
    background-color: hsl(206, 100%, 40%);
    border-color: hsl(206, 100%, 40%);
  }

  &.garyColor button,
  &.garyColor a {
    background-color: hsl(205, 46%, 92%);
    color: hsl(205, 47%, 42%);
    border-color: hsl(205, 41%, 63%);
  }

  &.garyColor button:hover,
  &.garyColor a:hover {
    background-color: hsl(205, 57%, 81%);
    color: hsl(205, 46%, 32%);
  }
`;

const BtnBasic = ({ children, className }) => {
  return <BtnBasicEl className={className}>{children}</BtnBasicEl>;
};

export default BtnBasic;
