# Jest

Jest is a delightful JavaScript Testing Framework with a focus on simplicity.

## TypeScript unit testing

JavaScript is programming language and Typescript is superset of javaScript.TypeScript unit testing differs from regular JavaScript unit testing in at least two ways. First of all, by leveraging static typing, a whole class of errors becomes impossible. So, you probably end up writing fewer tests. Also, TypeScript unit testing requires you to install some additional packages, which are needed to make the unit testing tools work with non-standard JavaScript syntax.

## Setup jest with React using TypeScript 

### Babel

Babel is a toolchain that is mainly used to convert ECMAScript 2015+ code into a backwards compatible version of JavaScript in current and older browsers or environments. Here are the main things Babel can do for you:

- Transform syntax
- Polyfill features that are missing in your target environment (through a third-party polyfill such as core-js)
- Source code transformations (codemods)

We need to use presets that have the environment in which we want the code to be converted. With Preset react, Babel will transpile the code when to react.

> `babel.config.json`

```json
{
     "presets": [
         "@babel/preset-env", 
         "@babel/preset-react", 
         "@babel/preset-typescript"
     ],
     "plugins": []
 }
```

> jest.config.json

```json
{
     "testEnvironment": "jsdom",
     "verbose": true,
     "moduleNameMapper": {
         "src/(.*)": "<rootDir>/src/$1",
               "\\.(jpg|jpeg|png|gif|eot|otf|webp|svg|ttf|woff|woff2|mp4|webm|wav|mp3|m4a|aac|oga)$": "<rootDir>/__mocks__/fileMock.js",
               "\\.(css|scss|less)$": "<rootDir>/__mocks__/styleMock.js"
      }
 }
```

> __ mocks __/styleMock.js

```js
module.exports = {};
```

> __ mocks __/fileMock.js

```js
module.exports = {};
```
