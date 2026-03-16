# FROM maven:3.8.2-jdk-8 # for Java 8
FROM node:23-alpine

WORKDIR /starter-project

COPY --chown=root:root --chmod=0444 package.json package-lock.json ./
RUN npm ci

COPY --chown=root:root --chmod=0444 index.html ./
COPY --chown=root:root --chmod=0444 vite.config.js babel.config.cjs jest.config.cjs jest.setup.js ./
COPY --chown=root:root src ./src
RUN find ./src -type d -exec chmod 0555 {} \; && find ./src -type f -exec chmod 0444 {} \;

USER node

CMD ["npm", "run", "dev"]