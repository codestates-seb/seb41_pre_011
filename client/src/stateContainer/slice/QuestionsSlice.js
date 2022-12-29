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
      state.QuestionsDummyData.push({
        questionId: 4,
        title: action.payload.title,
        questionContent: action.payload.problem,
        attemptContent: action.payload.trying,
        tag: [action.payload.tag],
      });
    },
    // delete(state, actions) {
    //   state.QuestionsDummyData.filter((it) => {
    //     it.id !== actions.payload;
    //   });
    // },
  },
});

export default QuestionsSlice.reducer;
export const { create } = QuestionsSlice.actions;
