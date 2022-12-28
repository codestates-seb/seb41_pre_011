import { createSlice } from '@reduxjs/toolkit';
import AnswerDummyData from '../../dummy/AnswerDummyData';

const initialState = {
  AnswerDummyData,
};

const AnswerSlice = createSlice({
  name: createSlice,
  initialState,
  reducers: {
    create(state, actions) {
      state.AnswerDummyData.push({ name: actions.payload.name });
    },
  },
});

export default AnswerSlice.reducer;
export const { create } = AnswerSlice.actions;
