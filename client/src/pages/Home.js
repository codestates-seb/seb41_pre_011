import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <div>
      <h1>home</h1>
      <Link to="/login">login</Link>
      <br />
      <Link to="/sing_up">sing_up</Link>
      <br />
      <Link to="/mypage">mypage</Link>
      <br />
      <Link to="/board">board</Link>
      <br />
      <Link to="/board_list">board_list</Link>
      <br />
      <Link to="/board_write">board_write</Link>
      <br />
      <Link to="/tag_list">tag_list</Link>
      <br />
      <Link to="/user_list">user_list</Link>
    </div>
  );
};
export default Home;
