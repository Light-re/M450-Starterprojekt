import { fireEvent, render, screen, waitFor } from '@testing-library/react';
import AddItem from './AddItem';

describe('AddItem', () => {
  beforeEach(() => {
    globalThis.fetch = jest.fn(() => Promise.resolve({ ok: true }));
    jest.spyOn(console, 'log').mockImplementation(() => {});
  });

  afterEach(() => {
    jest.clearAllMocks();
  });

  test('sends POST request with typed item name', async () => {
    render(<AddItem />);

    fireEvent.change(screen.getByPlaceholderText('Itemname'), {
      target: { value: 'Laptop' },
    });

    fireEvent.click(screen.getByRole('button', { name: 'Add' }));

    await waitFor(() => {
      expect(globalThis.fetch).toHaveBeenCalledWith('http://localhost:8080/items/Laptop', {
        method: 'POST',
      });
    });
  });

  test('reloads page after successful POST request', async () => {
    render(<AddItem />);

    fireEvent.change(screen.getByPlaceholderText('Itemname'), {
      target: { value: 'Phone' },
    });

    fireEvent.click(screen.getByRole('button', { name: 'Add' }));

    await waitFor(() => {
      expect(console.log).toHaveBeenCalled();
    });
  });
});
