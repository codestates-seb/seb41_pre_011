import styled from 'styled-components';

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

    &.readOnly .inpG {
      background-color: rgba(0, 0, 0, 0.05);
      cursor: not-allowed;
    }
    &.readOnly .inpG:focus {
      border: 1px solid hsl(210, 8%, 75%);
      box-shadow: none;
    }
  }
`;

const InpTxt = ({
  children,
  type,
  htmlId,
  placeholder,
  autoComplete,
  ariaLabel,
  hadIcon,
  onChange,
  value,
  required,
  readonly,
}) => {
  return (
    <InpTxtEl>
      <span className={readonly ? 'innerInpTxt readOnly' : 'innerInpTxt'}>
        {children}
        <input
          className={hadIcon ? 'inpG hadIcon' : 'inpG'}
          type={type ? type : 'text'}
          placeholder={placeholder ? placeholder : ''}
          autoComplete={autoComplete ? autoComplete : ''}
          aria-label={ariaLabel ? ariaLabel : ''}
          id={htmlId ? htmlId : ''}
          required={required ? required : ''}
          readOnly={readonly ? readonly : ''}
          // 기능
          value={value}
          onChange={(e) => {
            onChange(e.target.value);
          }}
        />
      </span>
    </InpTxtEl>
  );
};

export default InpTxt;
