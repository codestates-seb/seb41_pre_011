import { configureStore } from '@reduxjs/toolkit';
import QuestionsSlice from '../slice/QuestionsSlice';
import AnswerSlice from '../slice/AnswerSlice';
import CookieSlice from '../slice/CookieSlice';

const store = configureStore({
  reducer: {
    QuestionsSlice,
    AnswerSlice,
    CookieSlice,
  },
});

export default store;
