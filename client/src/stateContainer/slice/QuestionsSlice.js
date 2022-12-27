import { createSlice } from '@reduxjs/toolkit';
import QuestionsDummyData from '../../dummy/QuestionsDummyData';

const initialState = {
  QuestionsDummyData,
};

const QuestionsSlice = createSlice({
  name: 'QuestionsSlice',
  initialState,
  reducers: {
    create(state, action) {
      state.value.push({ title: action.payload.title });
    },
  },
});

export default QuestionsSlice.reducer;
export const { create } = QuestionsSlice.actions;
