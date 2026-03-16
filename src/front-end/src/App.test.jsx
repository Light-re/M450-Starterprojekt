import { render, screen } from '@testing-library/react';
import App from './App';

describe('App', () => {
  beforeEach(() => {
    globalThis.fetch = jest.fn(() =>
      Promise.resolve({
        ok: true,
        json: () => Promise.resolve([]),
      })
    );
  });

  afterEach(() => {
    jest.clearAllMocks();
  });

  test('renders Add Item and Item List sections', async () => {
    render(<App />);

    expect(screen.getByText('Add Item')).toBeInTheDocument();
    expect(await screen.findByText('Item List')).toBeInTheDocument();
  });
});
