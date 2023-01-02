import styled from 'styled-components';

const FooterEl = styled.footer`
  background-color: hsl(210, 8%, 15%);
  color: hsl(210, 8%, 60%);

  .innerFt {
    position: relative;
    max-width: 1264px;
    height: 322px;
    margin: 0 auto;
    padding: 32px 12px 12px 12px;
    box-sizing: border-box;
    display: flex;

    .logoFt {
      flex: 0 0 64px;
      margin-top: -12px;
    }

    .navFt {
      display: flex;
      flex: 2 1 auto;
      flex-wrap: wrap;

      .colNavFt {
        box-sizing: border-box;
        flex: 1 0 auto;
        padding-right: 12px;

        .titleNavFt {
          margin-bottom: 12px;
        }
        .titleNavFt a {
          font-weight: bold;
          text-transform: uppercase;
          color: hsl(210, 8%, 75%);
          font-size: 14px;
        }

        .listNavFt a {
          color: hsl(210, 8%, 60%);
          padding: 2px 0;
          display: inline-block;
          vertical-align: top;
          font-size: 14px;
        }
      }
    }

    .copyright {
      flex: 1 1 150px;
      display: flex;
      flex-direction: column;

      .listCopy {
        display: flex;

        li + li {
          margin-left: 12px;
        }

        .linkCopy {
          color: hsl(210, 8%, 60%);
          padding: 2px 0;
          display: inline-block;
          vertical-align: top;
          font-size: 13px;
        }
      }

      p {
        margin: auto 0 24px;
      }
    }
  }
`;

const Footer = () => {
  return (
    <FooterEl>
      <div className="innerFt">
        <div className="logoFt">
          <a href="#none" aria-label="Stack Overflow">
            <svg aria-hidden="true" width="32" height="37" viewBox="0 0 32 37">
              <path d="M26 33v-9h4v13H0V24h4v9h22Z" fill="#BCBBBB"></path>
              <path
                d="m21.5 0-2.7 2 9.9 13.3 2.7-2L21.5 0ZM26 18.4 13.3 7.8l2.1-2.5 12.7 10.6-2.1 2.5ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm14 10.79.68-2.95-16.1-3.35L7 23l16.1 2.99ZM23 30H7v-3h16v3Z"
                fill="#F48024"
              ></path>
            </svg>
          </a>
        </div>
        <nav className="navFt">
          <div className="colNavFt">
            <h5 className="titleNavFt">
              <a href="#none">Stack Overflow</a>
            </h5>
            <ul className="listNavFt">
              <li>
                <a href="#none">Questions</a>
              </li>
              <li>
                <a href="#none">Help</a>
              </li>
            </ul>
          </div>
          <div className="colNavFt">
            <h5 className="titleNavFt">
              <a href="#none">Products</a>
            </h5>
            <ul className="listNavFt">
              <li>
                <a
                  href="#none"
                  className="js-gps-track -link"
                  data-ga='["teams traffic","footer - site nav","stackoverflow.com/teams",null,{"dimension4":"teams"}]'
                  data-gps-track="footer.click({ location: 24, link: 29 })"
                >
                  Teams
                </a>
              </li>
              <li>
                <a
                  href="#none"
                  className="js-gps-track -link"
                  data-gps-track="footer.click({ location: 24, link: 21 })"
                >
                  Advertising
                </a>
              </li>
              <li>
                <a
                  href="#none"
                  className="js-gps-track -link"
                  data-gps-track="footer.click({ location: 24, link: 40 })"
                >
                  Collectives
                </a>
              </li>
              <li>
                <a
                  href="#none"
                  className="js-gps-track -link"
                  data-gps-track="footer.click({ location: 24, link: 20 })"
                >
                  Talent
                </a>
              </li>
            </ul>
          </div>
          <div className="colNavFt">
            <h5 className="titleNavFt">
              <a href="#none">Company</a>
            </h5>
            <ul className="listNavFt">
              <li>
                <a href="#none">About</a>
              </li>
              <li>
                <a href="#none">Press</a>
              </li>
              <li>
                <a href="#none">Work Here</a>
              </li>
              <li>
                <a href="#none">Legal</a>
              </li>
              <li>
                <a
                  className="js-gps-track -link"
                  data-gps-track="footer.click({ location: 24, link: 8 })"
                  href="#none"
                >
                  Privacy Policy
                </a>
              </li>
              <li>
                <a
                  className="js-gps-track -link"
                  data-gps-track="footer.click({ location: 24, link: 37 })"
                  href="#none"
                >
                  Terms of Service
                </a>
              </li>
              <li>
                <a
                  className="js-gps-track -link"
                  data-gps-track="footer.click({ location: 24, link: 13 })"
                  href="#none"
                >
                  Contact Us
                </a>
              </li>
              <li className="" id="consent-footer-link">
                <a href="#none">Cookie Settings</a>
              </li>
              <li>
                <a href="#none">Cookie Policy</a>
              </li>
            </ul>
          </div>
          <div className="colNavFt site-footer--categories-nav">
            <div>
              <h5 className="titleNavFt">
                <a
                  href="#none"
                  data-gps-track="footer.click({ location: 24, link: 30 })"
                >
                  Stack Exchange Network
                </a>
              </h5>
              <ul className="listNavFt">
                <li>
                  <a href="#none">Technology</a>
                </li>
                <li>
                  <a href="#none">Culture &amp; recreation</a>
                </li>
                <li>
                  <a href="#none">Life &amp; arts</a>
                </li>
                <li>
                  <a href="#none">Science</a>
                </li>
                <li>
                  <a href="#none">Professional</a>
                </li>
                <li>
                  <a href="#none">Business</a>
                </li>
                <li>
                  <a href="#none">API</a>
                </li>
                <li>
                  <a href="#none">Data</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        <div className="copyright">
          <ul className="listCopy">
            <li>
              <a className="linkCopy" href="https://stackoverflow.blog?blb=1">
                Blog
              </a>
            </li>
            <li>
              <a
                href="https://www.facebook.com/officialstackoverflow/"
                className="linkCopy"
              >
                Facebook
              </a>
            </li>
            <li>
              <a href="https://twitter.com/stackoverflow" className="linkCopy">
                Twitter
              </a>
            </li>
            <li>
              <a
                href="https://linkedin.com/company/stack-overflow"
                className="linkCopy"
              >
                LinkedIn
              </a>
            </li>
            <li>
              <a
                href="https://www.instagram.com/thestackoverflow"
                className="linkCopy"
              >
                Instagram
              </a>
            </li>
          </ul>
          <p>
            Site design / logo © 2022 Stack Exchange Inc; user contributions
            licensed under{' '}
            <span>
              <a href="https://stackoverflow.com/help/licensing">CC BY-SA</a>
            </span>
            . <span>rev&nbsp;2022.12.21.43127</span>
          </p>
        </div>
      </div>
    </FooterEl>
  );
};

export default Footer;
