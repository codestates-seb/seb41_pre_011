import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  QuestionsData: [],
  QpagingData: {},
};

const QuestionsSlice = createSlice({
  name: 'QuestionsSlice',
  initialState,
  reducers: {
    // create(state, action) {
    //   state.QuestionsDummyData.push({
    //     questionId: 4,
    //     title: action.payload.title,
    //     questionContent: action.payload.problem,
    //     attemptContent: action.payload.trying,
    //     tag: [action.payload.tag],
    //   });
    // },
    getQuestionsData(state, action) {
      state.QuestionsData = [...action.payload];
    },
    getQpagingData(state, action) {
      state.QpagingData = { ...action.payload };
    },
  },
});

export default QuestionsSlice.reducer;
export const { create, getQuestionsData, getQpagingData } =
  QuestionsSlice.actions;
