import { configureStore } from '@reduxjs/toolkit';
import QuestionsSlice from '../slice/QuestionsSlice';
import AnswerSlice from '../slice/AnswerSlice';

const store = configureStore({
  reducer: {
    QuestionsSlice,
    AnswerSlice,
  },
});

export default store;
