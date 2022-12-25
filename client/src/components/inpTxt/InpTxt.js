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
  }
`;

const InpTxt = ({ placeholder, autoComplete, ariaLabel, hadIcon }) => {
  return (
    <InpTxtEl>
      <span className="innerInpTxt">
        <svg
          aria-hidden="true"
          className="icoG"
          width="18"
          height="18"
          viewBox="0 0 18 18"
        >
          <path
            fill="hsl(210, 8%, 55%)"
            d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"
          ></path>
        </svg>
        <input
          className={hadIcon ? 'inpG hadIcon' : 'inpG'}
          type="text"
          placeholder={placeholder ? placeholder : ''}
          defaultValue=""
          onChange={console.log()}
          autoComplete={autoComplete ? autoComplete : ''}
          aria-label={ariaLabel ? ariaLabel : ''}
        />
      </span>
    </InpTxtEl>
  );
};

export default InpTxt;
