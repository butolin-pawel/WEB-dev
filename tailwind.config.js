/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js}"],
  theme: {
    extend: {
      colors: {
        'fox': '#FA4A0C'
      },
      backgroundImage: {
        'hd-img': "url('/src/img/desktop Hero Light 1.png')",
      }
    },
  },
  plugins: [],
}
