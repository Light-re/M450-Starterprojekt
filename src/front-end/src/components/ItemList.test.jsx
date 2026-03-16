import { render, screen, waitFor } from '@testing-library/react';
import ItemList from './ItemList';

describe('ItemList', () => {
  beforeEach(() => {
    globalThis.fetch = jest.fn(() =>
      Promise.resolve({
        ok: true,
        json: () => Promise.resolve([
          { id: 1, name: 'Keyboard' },
          { id: 2, name: 'Mouse' },
        ]),
      })
    );
  });

  afterEach(() => {
    jest.clearAllMocks();
  });

  test('loads and renders items from backend', async () => {
    render(<ItemList />);

    await waitFor(() => {
      expect(globalThis.fetch).toHaveBeenCalledWith('http://localhost:8080/items');
    });

    expect(await screen.findByText('Keyboard')).toBeInTheDocument();
    expect(screen.getByText('Mouse')).toBeInTheDocument();
  });

  test('logs an error when backend response is not ok', async () => {
    jest.spyOn(console, 'error').mockImplementation(() => {});
    globalThis.fetch = jest.fn(() =>
      Promise.resolve({
        ok: false,
      })
    );

    render(<ItemList />);

    await waitFor(() => {
      expect(console.error).toHaveBeenCalled();
    });
  });
});
