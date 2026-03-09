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
});
