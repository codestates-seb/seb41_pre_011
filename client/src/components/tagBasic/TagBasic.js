import styled from 'styled-components';

const TagEl = styled.a`
  display: inline-block;
  vertical-align: top;
  font-size: 12px;
  line-height: 13px;
  color: hsl(205, 47%, 42%);
  background-color: hsl(205, 46%, 92%);
  border: 1px solid transparent;
  border-radius: 3px;
  padding: 0.4em 0.5em;

  & + & {
    margin-left: 5px;
  }
  &:hover,
  &:focus {
    color: hsl(205, 46%, 32%);
    background-color: hsl(205, 53%, 88%);
  }
`;

const TagBasic = ({ children, className, href = '#none' }) => {
  return (
    <TagEl href={href} className={className}>
      {children}
    </TagEl>
  );
};

export default TagBasic;
