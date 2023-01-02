import styled from 'styled-components';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

/* components */
import Header from './components/header/Header';
import Aside from './components/aside/Aside';
import Footer from './components/footer/Footer';
const Container = styled.div`
  max-width: 1264px;
  min-height: calc(100vh - 372px);
  margin: 0 auto;
  position: relative;
  display: flex;
`;

/* redux_toolkit */
import { Provider } from 'react-redux';
import store from './stateContainer/store/store';

/* pages */
import Board from './pages/Board';
import Board_write from './pages/Board_write';
import Home from './pages/Home';
import Login from './pages/Login';
import Mypage from './pages/Mypage';
import Sing_up from './pages/Sing_up';
import Board_List from './pages/Board_list';
import Tag_list from './pages/Tag_list';
import User_list from './pages/User_list';
import Board_edit from './pages/Board_edit';
import Answer_edit from './pages/Answer_edit';

function App() {
  return (
    <BrowserRouter>
      <Provider store={store}>
        <div className="App">
          <Header />

          <Container>
            <Aside />
            <div className="content">
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/sing_up" element={<Sing_up />} />
                <Route path="/mypage" element={<Mypage />} />
                <Route path="/board" element={<Board />} />
                <Route path="/board_list" element={<Board_List />} />
                <Route path="/board_write" element={<Board_write />} />
                <Route path="/board_edit" element={<Board_edit />} />
                <Route path="/tag_list" element={<Tag_list />} />
                <Route path="/user_list" element={<User_list />} />
                <Route path="/answer_edit" element={<Answer_edit />} />
              </Routes>
            </div>
          </Container>

          <Footer />
        </div>
      </Provider>
    </BrowserRouter>
  );
}

export default App;
