import styled from 'styled-components';
import InpTxt from '../inpTxt/InpTxt';
import BtnBasic from '../btnBasic/BtnBasic';

const HeaderWrapper = styled.div`
  height: 50px;
`;

const HeaderEl = styled.header`
  position: fixed;
  left: 0;
  right: 0;
  top: 0;
  z-index: 100;
  box-sizing: border-box;
  background-color: hsl(210, 8%, 97.5%);
  border-top: 3px solid hsl(27, 90%, 55%);
  box-shadow: 0 1px 2px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05),
    0 2px 8px hsla(0, 0%, 0%, 0.05);
  .innerHd {
    display: flex;
    max-width: 1264px;
    margin: 0 auto;
  }
`;

const LogoHd = styled.h1`
  padding: 0 8px;
  & > a {
    display: block;
    height: 47px;
    display: flex;
    align-items: center;
  }

  .logo {
    display: block;
    width: 150px;
    height: 30px;
    margin-top: -4px;
    background-position: 0 -500px;
  }
`;

const UtilsHd = styled.div`
  margin-left: auto;
  display: flex;
  justify-content: flex-end;
  flex: 1;
  width: 100%;

  form {
    display: flex;
    align-items: center;
    width: 700px;
    box-sizing: border-box;
    padding: 0 8px;
  }

  .linkBoxHd {
    display: flex;
    ul {
      display: flex;
      li {
        display: flex;
        align-items: center;
      }
      li + li {
        margin-left: 4px;
      }
    }
  }
`;
const BtnInLinkBoxHd = styled(BtnBasic)`
  button,
  a {
    padding: 6px 0.8em;
  }
`;

const Header = () => {
  return (
    <HeaderWrapper>
      <HeaderEl>
        <div className="innerHd">
          <LogoHd>
            <a href="#none">
              <span className="logo icoSprite">
                <span className="blind">Stack Overflow</span>
              </span>
            </a>
          </LogoHd>

          <UtilsHd>
            <form>
              <InpTxt
                placeholder="Search…"
                autoComplete="off"
                ariaLabel="Search"
                hadIcon={true}
              />
            </form>

            <div className="linkBoxHd">
              <ul className="listLogin">
                <li>
                  <BtnInLinkBoxHd link="true" className="garyColor">
                    Log in
                  </BtnInLinkBoxHd>
                </li>
                <li>
                  <BtnInLinkBoxHd link="true">Sign Up</BtnInLinkBoxHd>
                </li>
              </ul>
            </div>
          </UtilsHd>
        </div>
      </HeaderEl>
    </HeaderWrapper>
  );
};

export default Header;