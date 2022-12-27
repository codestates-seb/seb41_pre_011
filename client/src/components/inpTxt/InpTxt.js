import styled from 'styled-components';
import { useState } from 'react';

const InpTxtEl = styled.span`
  display: block;
  width: 100%;

  .innerInpTxt {
    width: 100%;
    display: block;
    position: relative;

    .icoG {
      position: absolute;
      left: 0.7em;
      top: 50%;
      margin-top: -9px;
    }

    .inpG {
      display: block;
      width: 100%;
      height: 33px;
      box-sizing: border-box;
      padding: 0.6em 0.7em;
      border: 1px solid hsl(210, 8%, 75%);
      border-radius: 3px;
      background-color: hsl(0, 0%, 100%);
      color: hsl(210, 8%, 25%);
    }

    .inpG:focus {
      border-color: hsl(206, 90%, 69.5%);
      box-shadow: 0 0 0 4px hsl(210, 59%, 74%, 0.4);
      outline: none;
    }

    .inpG.hadIcon {
      padding-left: 32px;
    }
  }
`;

const InpTxt = ({
  children,
  placeholder,
  autoComplete,
  ariaLabel,
  hadIcon,
}) => {
  const [title, setTitle] = useState('');
  return (
    <InpTxtEl>
      <span className="innerInpTxt">
        {children}
        <input
          className={hadIcon ? 'inpG hadIcon' : 'inpG'}
          type="text"
          placeholder={placeholder ? placeholder : ''}
          autoComplete={autoComplete ? autoComplete : ''}
          aria-label={ariaLabel ? ariaLabel : ''}
          // 기능
          value={title}
          onChange={(e) => {
            setTitle(e.target.value);
          }}
        />
      </span>
    </InpTxtEl>
  );
};

export default InpTxt;
