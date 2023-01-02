import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  AnswerData: [],
};

const AnswerSlice = createSlice({
  name: 'AnswerSlice',
  initialState,
  reducers: {
    getAnswerData(state, actions) {
      state.AnswerData = [...actions.payload];
    },
  },
});

export default AnswerSlice.reducer;
export const { getAnswerData } = AnswerSlice.actions;
