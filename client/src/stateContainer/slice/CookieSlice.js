import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  cookieData: false,
};

const CookieSlice = createSlice({
  name: 'CookieSlice',
  initialState,
  reducers: {
    getCookieData(state, actions) {
      state.cookieData = actions.payload;
    },
  },
});

export default CookieSlice.reducer;
export const { getCookieData } = CookieSlice.actions;
