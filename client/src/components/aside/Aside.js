import styled from 'styled-components';
import { Link, useLocation } from 'react-router-dom';

const AsideEl = styled.aside`
  width: 164px;
  box-sizing: border-box;
  flex-shrink: 0;
  border-right: 1px solid hsl(210, 8%, 85%);

  .listNav {
    position: sticky;
    top: 50px;
    padding-top: 12px;

    .titNav {
      display: block;
      color: hsl(210, 8%, 45%);
      font-weight: normal;
      box-sizing: border-box;
      padding: 16px 0 4px 8px;

      &.titHomeNav {
        padding: 9px 0 0 0;

        .linkNav {
          padding-left: 8px;
          margin-bottom: -3px;
        }
      }
    }

    .linkNav {
      display: block;
      position: relative;
      padding: 7px 4px 7px 30px;
      box-sizing: border-box;
      color: hsl(210, 8%, 35%);

      .icoNav {
        position: absolute;
        left: 8px;
        top: 6px;
      }
      .icoClrOrange {
        fill: hsl(27, 90%, 55%);
      }
    }

    .on .linkNav {
      border-right: 3px solid hsl(27, 90%, 55%);
      background-color: hsl(210, 8%, 95%);
      color: hsl(210, 8%, 5%);
      font-weight: bold;
    }
  }
`;

const Aside = () => {
  const { pathname } = useLocation();
  return (
    <AsideEl>
      <ul className="listNav">
        <li className={pathname === '/' ? 'on' : undefined}>
          <strong className="titNav titHomeNav">
            <Link to="/" className="linkNav">
              Home
            </Link>
          </strong>
        </li>
        <li>
          <strong className="titNav">PUBLIC</strong>
          <ul className="listSubNav">
            <li className={pathname === '/board_list' ? 'on' : undefined}>
              <Link to="/board_list" className="linkNav">
                <svg
                  aria-hidden="true"
                  className="icoNav"
                  width="18"
                  height="18"
                  viewBox="0 0 18 18"
                >
                  <path d="M9 1C4.64 1 1 4.64 1 9c0 4.36 3.64 8 8 8 4.36 0 8-3.64 8-8 0-4.36-3.64-8-8-8ZM8 15.32a6.46 6.46 0 0 1-4.3-2.74 6.46 6.46 0 0 1-.93-5.01L7 11.68v.8c0 .88.12 1.32 1 1.32v1.52Zm5.72-2c-.2-.66-1-1.32-1.72-1.32h-1v-2c0-.44-.56-1-1-1H6V7h1c.44 0 1-.56 1-1V5h2c.88 0 1.4-.72 1.4-1.6v-.33a6.45 6.45 0 0 1 3.83 4.51 6.45 6.45 0 0 1-1.51 5.73v.01Z"></path>
                </svg>
                <span>Questions</span>
              </Link>
            </li>
            <li className={pathname === '/tag_list' ? 'on' : undefined}>
              <Link to="/tag_list?page=1" className="linkNav">
                <span>Tags</span>
              </Link>
            </li>
            <li className={pathname === '/user_list' ? 'on' : undefined}>
              <Link to="/user_list?page=1" className="linkNav">
                <span>Users</span>
              </Link>
            </li>
          </ul>
        </li>
        <li>
          <strong className="titNav">COLLECTIVES</strong>
          <a
            href="https://stackoverflow.com/collectives"
            className="linkNav"
            target="_blank"
            rel="noreferrer"
          >
            <svg
              aria-hidden="true"
              className="icoNav icoClrOrange"
              width="18"
              height="18"
              viewBox="0 0 18 18"
            >
              <path d="M9.86.89a1.14 1.14 0 0 0-1.72 0l-.5.58c-.3.35-.79.48-1.23.33l-.72-.25a1.14 1.14 0 0 0-1.49.85l-.14.76c-.1.45-.45.8-.9.9l-.76.14c-.67.14-1.08.83-.85 1.49l.25.72c.15.44.02.92-.33 1.23l-.58.5a1.14 1.14 0 0 0 0 1.72l.58.5c.35.3.48.79.33 1.23l-.25.72c-.23.66.18 1.35.85 1.49l.76.14c.45.1.8.45.9.9l.14.76c.14.67.83 1.08 1.49.85l.72-.25c.44-.15.92-.02 1.23.33l.5.58c.46.52 1.26.52 1.72 0l.5-.58c.3-.35.79-.48 1.23-.33l.72.25c.66.23 1.35-.18 1.49-.85l.14-.76c.1-.45.45-.8.9-.9l.76-.14c.67-.14 1.08-.83.85-1.49l-.25-.72c-.15-.44-.02-.92.33-1.23l.58-.5c.52-.46.52-1.26 0-1.72l-.58-.5c-.35-.3-.48-.79-.33-1.23l.25-.72a1.14 1.14 0 0 0-.85-1.49l-.76-.14c-.45-.1-.8-.45-.9-.9l-.14-.76a1.14 1.14 0 0 0-1.49-.85l-.72.25c-.44.15-.92.02-1.23-.33l-.5-.58Zm-.49 2.67L10.6 6.6c.05.15.19.24.34.25l3.26.22c.36.03.5.48.23.71l-2.5 2.1a.4.4 0 0 0-.14.4l.8 3.16a.4.4 0 0 1-.6.44L9.2 12.13a.4.4 0 0 0-.42 0l-2.77 1.74a.4.4 0 0 1-.6-.44l.8-3.16a.4.4 0 0 0-.13-.4l-2.5-2.1a.4.4 0 0 1 .22-.7l3.26-.23a.4.4 0 0 0 .34-.25l1.22-3.03a.4.4 0 0 1 .74 0Z"></path>
            </svg>
            <span>Explore Collectives</span>
          </a>
        </li>
        <li>
          <strong className="titNav">TEAMS</strong>
          <a
            href="https://stackoverflowteams.com/"
            className="linkNav"
            target="_blank"
            rel="noreferrer"
          >
            <svg
              aria-hidden="true"
              className="icoNav icoClrOrange"
              width="18"
              height="18"
              viewBox="0 0 18 18"
            >
              <path d="M9.86.89a1.14 1.14 0 0 0-1.72 0l-.5.58c-.3.35-.79.48-1.23.33l-.72-.25a1.14 1.14 0 0 0-1.49.85l-.14.76c-.1.45-.45.8-.9.9l-.76.14c-.67.14-1.08.83-.85 1.49l.25.72c.15.44.02.92-.33 1.23l-.58.5a1.14 1.14 0 0 0 0 1.72l.58.5c.35.3.48.79.33 1.23l-.25.72c-.23.66.18 1.35.85 1.49l.76.14c.45.1.8.45.9.9l.14.76c.14.67.83 1.08 1.49.85l.72-.25c.44-.15.92-.02 1.23.33l.5.58c.46.52 1.26.52 1.72 0l.5-.58c.3-.35.79-.48 1.23-.33l.72.25c.66.23 1.35-.18 1.49-.85l.14-.76c.1-.45.45-.8.9-.9l.76-.14c.67-.14 1.08-.83.85-1.49l-.25-.72c-.15-.44-.02-.92.33-1.23l.58-.5c.52-.46.52-1.26 0-1.72l-.58-.5c-.35-.3-.48-.79-.33-1.23l.25-.72a1.14 1.14 0 0 0-.85-1.49l-.76-.14c-.45-.1-.8-.45-.9-.9l-.14-.76a1.14 1.14 0 0 0-1.49-.85l-.72.25c-.44.15-.92.02-1.23-.33l-.5-.58Zm-.49 2.67L10.6 6.6c.05.15.19.24.34.25l3.26.22c.36.03.5.48.23.71l-2.5 2.1a.4.4 0 0 0-.14.4l.8 3.16a.4.4 0 0 1-.6.44L9.2 12.13a.4.4 0 0 0-.42 0l-2.77 1.74a.4.4 0 0 1-.6-.44l.8-3.16a.4.4 0 0 0-.13-.4l-2.5-2.1a.4.4 0 0 1 .22-.7l3.26-.23a.4.4 0 0 0 .34-.25l1.22-3.03a.4.4 0 0 1 .74 0Z"></path>
            </svg>
            <span>Create free Team</span>
          </a>
        </li>
      </ul>
    </AsideEl>
  );
};

export default Aside;
