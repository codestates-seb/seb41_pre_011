import { Link } from 'react-router-dom';
import styled from 'styled-components';

const PagingEl = styled.div`
  display: flex;
  box-sizing: border-box;
  padding: 20px;
  align-items: center;
  justify-content: center;

  ul {
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    justify-content: center;

    li {
      margin: 3px;

      a {
        display: flex;
        align-items: center;
        box-sizing: border-box;
        border-radius: 2px;
        height: 25px;
        font-size: 14px;
        padding: 0 7px;
        background-color: #fff;
        border: 1px solid rgb(214, 217, 220);
        color: rgb(59, 64, 69);
      }
      a:hover {
        background-color: rgba(160, 160, 160, 0.2);
      }

      &.on a {
        color: #fff;
        background-color: rgb(244, 130, 37);
        border-color: rgb(244, 130, 37);
      }
    }
  }
`;

const Paging = ({ location, pagingArr }) => {
  return (
    <PagingEl>
      <strong className="blind">페이징 목록</strong>
      <ul>
        {pagingArr.map((el, idx) => {
          return (
            <li key={idx} className={el.nowNum ? 'on' : ''}>
              <Link to={`${location}?page=${el.num}`}>{el.num}</Link>
            </li>
          );
        })}
      </ul>
    </PagingEl>
  );
};

export default Paging;
