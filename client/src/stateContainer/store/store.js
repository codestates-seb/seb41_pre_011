import { configureStore } from '@reduxjs/toolkit';
import QuestionsSlice from '../slice/QuestionsSlice';

const store = configureStore({
  reducer: {
    QuestionsSlice,
  },
});

export default store;
