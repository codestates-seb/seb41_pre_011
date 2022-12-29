import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  AnswerData: [],
};

const AnswerSlice = createSlice({
  name: createSlice,
  initialState,
  reducers: {
    create(state, actions) {
      state.AnswerData.push({ name: actions.payload.name });
    },
  },
});

export default AnswerSlice.reducer;
export const { create } = AnswerSlice.actions;
