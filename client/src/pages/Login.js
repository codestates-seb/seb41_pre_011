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

  .formLogoRow {
    margin-bottom: 22px;

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

const Login = () => {
  return (
    <Wrapper>
      <WrapForm>
        <form>
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
              <span>Log in</span>
            </h2>
          </div>
          <div className="formContent">
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
                type="password"
              />
            </div>
            <div className="formContentRow">
              <BtnForm>
                <button type="submit">Log in</button>
              </BtnForm>
            </div>
          </div>
        </form>
        <SignUpRow>
          Don’t have an account? <Link to="/sing_up">Sign up</Link>
        </SignUpRow>
      </WrapForm>
    </Wrapper>
  );
};
export default Login;
