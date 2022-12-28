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
        title: action.payload.title,
        questionContent: action.payload.title.problem,
        attemptContent: action.payload.title.tag,
      });
      console.log(state.QuestionsDummyData);
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
