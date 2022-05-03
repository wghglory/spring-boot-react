import React, {useState} from 'react';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';

import {CarPayload} from '../models/Car';
import {Button} from '@mui/material';

export default function CarAdd({addCar}: {addCar: (car: CarPayload) => void}) {
  const [open, setOpen] = useState(false);
  const [car, setCar] = useState<CarPayload>({
    brand: '',
    model: '',
    color: '',
    year: '',
    price: '',
  });

  // Open the modal form
  const handleClickOpen = () => {
    setOpen(true);
  };

  // Close the modal form
  const handleClose = () => {
    setOpen(false);
  };

  // Save car and close modal form
  const handleSave = () => {
    addCar(car);
    handleClose();
  };

  function handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    setCar({...car, [event.target.name]: event.target.value});
  }

  return (
    <div>
      <Button variant="contained" onClick={handleClickOpen}>
        New Car
      </Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>New car</DialogTitle>
        <DialogContent>
          <Stack spacing={2} mt={1}>
            <TextField
              label="Brand"
              name="brand"
              autoFocus
              variant="standard"
              value={car.brand}
              onChange={handleChange}
            />
            <TextField label="Model" name="model" variant="standard" value={car.model} onChange={handleChange} />
            <TextField label="Color" name="color" variant="standard" value={car.color} onChange={handleChange} />
            <TextField label="Year" name="year" variant="standard" value={car.year} onChange={handleChange} />
            <TextField label="Price" name="price" variant="standard" value={car.price} onChange={handleChange} />
          </Stack>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancel</Button>
          <Button onClick={handleSave}>Save</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
