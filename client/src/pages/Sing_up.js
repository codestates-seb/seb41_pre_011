import styled from 'styled-components';
import InpTxt from '../components/inpTxt/InpTxt';
import BtnBasic from '../components/btnBasic/BtnBasic';
import { Link } from 'react-router-dom';

const Wrapper = styled.div`
  width: 1100px;
  box-sizing: border-box;
  padding: 24px 24px 80px;
  margin: 0 auto;
  background-color: hsl(210, 8%, 97.5%);
  min-height: calc(100vh - 372px);
`;

const WrapForm = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: calc(100vh - 540px);
  flex-direction: column;
  box-sizing: border-box;
  padding-bottom: 90px;

  & form {
    display: flex;

    .sideBar {
      margin-right: 40px;
      display: flex;
      flex-direction: column;
      justify-content: center;

      .titSb {
        color: rgba(35, 38, 41);
        font-size: 27px;
        font-weight: normal;
        margin-bottom: 12px;
      }

      .descSb {
        display: flex;
        align-items: center;
        margin-bottom: 8px;
        width: 100%;
        font-size: 15px;
        color: rgba(51, 51, 51);
        .icoDesc {
          margin-right: 8px;
          svg {
            fill: hsl(206, 100%, 52%);
          }
        }
      }
    }
  }

  .formLogoRow {
    margin-bottom: 24px;

    .titForm {
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 23px;

      span {
        padding: 18px 0 0 6px;
      }
    }
  }

  .formContent {
    padding: 24px;
    background-color: #fff;
    box-shadow: 0 10px 24px hsla(0, 0%, 0%, 0.05),
      0 20px 48px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.1);
    width: 290px;
    box-sizing: border-box;
    border-radius: 8px;

    .formContentRow + .formContentRow {
      margin-top: 16px;
    }

    .inpLabel {
      font-size: 15px;
      font-weight: bold;
      color: rgba(12, 13, 14);
      display: block;
      margin-bottom: 1px;
    }
  }
`;

const BtnForm = styled(BtnBasic)`
  display: block;
  width: 100%;

  & a,
  & button {
    display: block;
    width: 100%;
  }
`;

const SignUpRow = styled.div`
  text-align: center;
  color: rgba(35, 38, 41);
  font-size: 15px;
  margin-top: 20px;
  & a {
    color: rgba(10, 149, 255);
  }

  & a:hover {
    color: rgba(0, 116, 204);
  }
`;

const Sing_up = () => {
  return (
    <Wrapper>
      <WrapForm>
        <form>
          <div className="sideBar">
            <h2 className="titSb">Join the Stack Overflow community</h2>
            <div className="descSb">
              <div className="icoDesc">
                <svg width="26" height="26">
                  <path
                    opacity=".5"
                    d="M4.2 4H22a2 2 0 012 2v11.8a3 3 0 002-2.8V5a3 3 0 00-3-3H7a3 3 0 00-2.8 2z"
                  ></path>
                  <path d="M1 7c0-1.1.9-2 2-2h18a2 2 0 012 2v12a2 2 0 01-2 2h-2v5l-5-5H3a2 2 0 01-2-2V7zm10.6 11.3c.7 0 1.2-.5 1.2-1.2s-.5-1.2-1.2-1.2c-.6 0-1.2.4-1.2 1.2 0 .7.5 1.1 1.2 1.2zm2.2-5.4l1-.9c.3-.4.4-.9.4-1.4 0-1-.3-1.7-1-2.2-.6-.5-1.4-.7-2.4-.7-.8 0-1.4.2-2 .5-.7.5-1 1.4-1 2.8h1.9v-.1c0-.4 0-.7.2-1 .2-.4.5-.6 1-.6s.8.1 1 .4a1.3 1.3 0 010 1.8l-.4.3-1.4 1.3c-.3.4-.4 1-.4 1.6 0 0 0 .2.2.2h1.5c.2 0 .2-.1.2-.2l.1-.7.5-.7.6-.4z"></path>
                </svg>
              </div>
              Get unstuck — ask a question
            </div>
            <div className="descSb">
              <div className="icoDesc">
                <svg width="26" height="26">
                  <path d="M12 .7a2 2 0 013 0l8.5 9.6a1 1 0 01-.7 1.7H4.2a1 1 0 01-.7-1.7L12 .7z"></path>
                  <path
                    opacity=".5"
                    d="M20.6 16H6.4l7.1 8 7-8zM15 25.3a2 2 0 01-3 0l-8.5-9.6a1 1 0 01.7-1.7h18.6a1 1 0 01.7 1.7L15 25.3z"
                  ></path>
                </svg>
              </div>
              Unlock new privileges like voting and commenting
            </div>
            <div className="descSb">
              <div className="icoDesc">
                <svg width="26" height="26">
                  <path d="M14.8 3a2 2 0 00-1.4.6l-10 10a2 2 0 000 2.8l8.2 8.2c.8.8 2 .8 2.8 0l10-10c.4-.4.6-.9.6-1.4V5a2 2 0 00-2-2h-8.2zm5.2 7a2 2 0 110-4 2 2 0 010 4z"></path>
                  <path
                    opacity=".5"
                    d="M13 0a2 2 0 00-1.4.6l-10 10a2 2 0 000 2.8c.1-.2.3-.6.6-.8l10-10a2 2 0 011.4-.6h9.6a2 2 0 00-2-2H13z"
                  ></path>
                </svg>
              </div>
              Save your favorite tags, filters, and jobs
            </div>
            <div className="descSb">
              <div className="icoDesc">
                <svg width="26" height="26">
                  <path d="M21 4V2H5v2H1v5c0 2 2 4 4 4v1c0 2.5 3 4 7 4v3H7s-1.2 2.3-1.2 3h14.4c0-.6-1.2-3-1.2-3h-5v-3c4 0 7-1.5 7-4v-1c2 0 4-2 4-4V4h-4zM5 11c-1 0-2-1-2-2V6h2v5zm11.5 2.7l-3.5-2-3.5 1.9L11 9.8 7.2 7.5h4.4L13 3.8l1.4 3.7h4L15.3 10l1.4 3.7h-.1zM23 9c0 1-1 2-2 2V6h2v3z"></path>
                </svg>
              </div>
              Earn reputation and badges
            </div>
            <div className="txtNotiSb">
              Collaborate and share knowledge with a private group for FREE.
            </div>
          </div>
          <div className="mainBar">
            <div className="formLogoRow">
              <h2 className="titForm">
                <svg
                  aria-hidden="true"
                  width="32"
                  height="37"
                  viewBox="0 0 32 37"
                >
                  <path d="M26 33v-9h4v13H0V24h4v9h22Z" fill="#BCBBBB"></path>
                  <path
                    d="m21.5 0-2.7 2 9.9 13.3 2.7-2L21.5 0ZM26 18.4 13.3 7.8l2.1-2.5 12.7 10.6-2.1 2.5ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm14 10.79.68-2.95-16.1-3.35L7 23l16.1 2.99ZM23 30H7v-3h16v3Z"
                    fill="#F48024"
                  ></path>
                </svg>
                <span>Sing up</span>
              </h2>
            </div>
            <div className="formContent">
              <div className="formContentRow">
                <label className="inpLabel" htmlFor="name">
                  Display name
                </label>
                <InpTxt
                  htmlId="name"
                  autoComplete="off"
                  value={``}
                  onChange={console.log(123)}
                  required={true}
                />
              </div>
              <div className="formContentRow">
                <label className="inpLabel" htmlFor="email">
                  Email
                </label>
                <InpTxt
                  htmlId="email"
                  autoComplete="off"
                  value={``}
                  onChange={console.log(123)}
                  required={true}
                />
              </div>
              <div className="formContentRow">
                <label className="inpLabel" htmlFor="password">
                  Password
                </label>
                <InpTxt
                  htmlId="password"
                  autoComplete="off"
                  value={``}
                  onChange={console.log(123)}
                  required={true}
                />
              </div>
              <div className="formContentRow">
                <BtnForm>
                  <button type="submit">Sign up</button>
                </BtnForm>
              </div>
            </div>
            <SignUpRow>
              Already have an account? <Link to="/login">Log in</Link>
            </SignUpRow>
          </div>
        </form>
      </WrapForm>
    </Wrapper>
  );
};
export default Sing_up;
